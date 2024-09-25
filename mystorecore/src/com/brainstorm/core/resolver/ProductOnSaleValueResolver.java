package com.brainstorm.core.resolver;

import com.brainstorm.core.model.MyStoreProductModel;
import de.hybris.platform.catalog.model.classification.ClassificationAttributeValueModel;
import de.hybris.platform.classification.ClassificationService;
import de.hybris.platform.classification.features.FeatureList;
import de.hybris.platform.classification.features.FeatureValue;
import de.hybris.platform.classification.features.LocalizedFeature;
import de.hybris.platform.core.model.c2l.LanguageModel;
import de.hybris.platform.servicelayer.i18n.CommonI18NService;
import de.hybris.platform.solrfacetsearch.config.FacetSearchConfig;
import de.hybris.platform.solrfacetsearch.config.IndexConfig;
import de.hybris.platform.solrfacetsearch.config.IndexedProperty;
import de.hybris.platform.solrfacetsearch.config.exceptions.FieldValueProviderException;
import de.hybris.platform.solrfacetsearch.indexer.IndexerBatchContext;
import de.hybris.platform.solrfacetsearch.indexer.spi.InputDocument;
import de.hybris.platform.solrfacetsearch.provider.ValueResolver;
import java.util.Objects;
import de.hybris.platform.classification.features.Feature;


import javax.annotation.Resource;
import java.util.Collection;

public class ProductOnSaleValueResolver implements ValueResolver<MyStoreProductModel> {
    @Resource
    private ClassificationService classificationService;
    @Resource
    private CommonI18NService commonI18NService;

    @Override
    public void resolve(InputDocument inputDocument, IndexerBatchContext indexerBatchContext, Collection<IndexedProperty> indexedProperties, MyStoreProductModel myStoreProductModel) throws FieldValueProviderException {
        FacetSearchConfig facetSearchConfig = indexerBatchContext.getFacetSearchConfig();
        IndexConfig indexConfig = facetSearchConfig.getIndexConfig();
        FeatureList featureList = classificationService.getFeatures(myStoreProductModel);
        if (Objects.nonNull(featureList)) {
            for (IndexedProperty indexedProperty : indexedProperties) {
                if (indexedProperty.isLocalized()) {
                    final Collection<LanguageModel> languages = indexConfig.getLanguages();
                    for (final LanguageModel language : languages) {
                        commonI18NService.setCurrentLanguage(language);
                        addFieldValue(inputDocument, indexedProperty, language, featureList);
                    }
                } else {
                    addFieldValue(inputDocument, indexedProperty, null, featureList);
                }
            }
        }
    }

    private void addFieldValue(InputDocument inputDocument, IndexedProperty indexedProperty, LanguageModel languageModel, FeatureList featureList) throws FieldValueProviderException {
        Feature feature = findFeature(featureList, indexedProperty);
        if (Objects.nonNull(feature)) {
            String isoCode = Objects.nonNull(languageModel) ? languageModel.getIsocode() : null;
            FeatureValue featureValue;
            if ((feature instanceof LocalizedFeature) && Objects.nonNull(languageModel)) {
                featureValue = ((LocalizedFeature) feature).getValue(commonI18NService.getLocaleForLanguage(languageModel));
            } else {
                featureValue = feature.getValue();
            }
            inputDocument.addField(indexedProperty, getFeatureValue(featureValue), isoCode);
        }

    }

    private Object getFeatureValue(FeatureValue featureValue) {
        Object featureVal = Objects.nonNull(featureValue) ? featureValue.getValue() : null;
        if (featureVal instanceof ClassificationAttributeValueModel) {
            return ((ClassificationAttributeValueModel) featureVal).getName();
        } else {
            return featureVal;
        }
    }

    private Feature findFeature(FeatureList featureList, IndexedProperty indexedProperty) {
        return featureList.getFeatures().stream().filter(feature -> feature.getCode().contains(indexedProperty.getName())).findFirst().orElse(null);
    }

}
