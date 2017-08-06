/*
 * [y] hybris Platform
 *
 * Copyright (c) 2017 SAP SE or an SAP affiliate company.  All rights reserved.
 *
 * This software is the confidential and proprietary information of SAP
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 * license agreement you entered into with SAP.
 */
package by.warranty.fulfilmentprocess.jalo;

import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import by.warranty.fulfilmentprocess.constants.WarrantyFulfilmentProcessConstants;

@SuppressWarnings("PMD")
public class WarrantyFulfilmentProcessManager extends GeneratedWarrantyFulfilmentProcessManager
{
	public static final WarrantyFulfilmentProcessManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (WarrantyFulfilmentProcessManager) em.getExtension(WarrantyFulfilmentProcessConstants.EXTENSIONNAME);
	}
	
}
