/*
 * ----------------------------------------------------------------
 * --- WARNING: THIS FILE IS GENERATED AND WILL BE OVERWRITTEN! ---
 * --- Generated at Oct 8, 2024, 4:01:17 PM                     ---
 * ----------------------------------------------------------------
 */
package com.brainstorm.core.jalo;

import com.brainstorm.core.constants.MystoreCoreConstants;
import de.hybris.platform.jalo.Item.AttributeMode;
import de.hybris.platform.jalo.SessionContext;
import de.hybris.platform.jalo.product.Product;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Generated class for type {@link com.brainstorm.core.jalo.MyStoreProduct MyStoreProduct}.
 */
@SuppressWarnings({"deprecation","unused","cast"})
public abstract class GeneratedMyStoreProduct extends Product
{
	/** Qualifier of the <code>MyStoreProduct.onSale</code> attribute **/
	public static final String ONSALE = "onSale";
	protected static final Map<String, AttributeMode> DEFAULT_INITIAL_ATTRIBUTES;
	static
	{
		final Map<String, AttributeMode> tmp = new HashMap<String, AttributeMode>(Product.DEFAULT_INITIAL_ATTRIBUTES);
		tmp.put(ONSALE, AttributeMode.INITIAL);
		DEFAULT_INITIAL_ATTRIBUTES = Collections.unmodifiableMap(tmp);
	}
	@Override
	protected Map<String, AttributeMode> getDefaultAttributeModes()
	{
		return DEFAULT_INITIAL_ATTRIBUTES;
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyStoreProduct.onSale</code> attribute.
	 * @return the onSale
	 */
	public String getOnSale(final SessionContext ctx)
	{
		return (String)getProperty( ctx, ONSALE);
	}
	
	/**
	 * <i>Generated method</i> - Getter of the <code>MyStoreProduct.onSale</code> attribute.
	 * @return the onSale
	 */
	public String getOnSale()
	{
		return getOnSale( getSession().getSessionContext() );
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyStoreProduct.onSale</code> attribute. 
	 * @param value the onSale
	 */
	public void setOnSale(final SessionContext ctx, final String value)
	{
		setProperty(ctx, ONSALE,value);
	}
	
	/**
	 * <i>Generated method</i> - Setter of the <code>MyStoreProduct.onSale</code> attribute. 
	 * @param value the onSale
	 */
	public void setOnSale(final String value)
	{
		setOnSale( getSession().getSessionContext(), value );
	}
	
}
