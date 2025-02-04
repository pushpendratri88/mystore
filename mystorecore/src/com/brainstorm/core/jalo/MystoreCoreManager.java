/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */
package com.brainstorm.core.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import com.brainstorm.core.constants.MystoreCoreConstants;
import com.brainstorm.core.setup.CoreSystemSetup;


/**
 * Do not use, please use {@link CoreSystemSetup} instead.
 * 
 */
public class MystoreCoreManager extends GeneratedMystoreCoreManager
{
	public static final MystoreCoreManager getInstance()
	{
		final ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (MystoreCoreManager) em.getExtension(MystoreCoreConstants.EXTENSIONNAME);
	}
}
