package by.warranty.addon.jalo;

import by.warranty.addon.constants.WarrantysaddonConstants;
import de.hybris.platform.jalo.JaloSession;
import de.hybris.platform.jalo.extension.ExtensionManager;
import org.apache.log4j.Logger;

@SuppressWarnings("PMD")
public class WarrantysaddonManager extends GeneratedWarrantysaddonManager
{
	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger( WarrantysaddonManager.class.getName() );
	
	public static final WarrantysaddonManager getInstance()
	{
		ExtensionManager em = JaloSession.getCurrentSession().getExtensionManager();
		return (WarrantysaddonManager) em.getExtension(WarrantysaddonConstants.EXTENSIONNAME);
	}
	
}
