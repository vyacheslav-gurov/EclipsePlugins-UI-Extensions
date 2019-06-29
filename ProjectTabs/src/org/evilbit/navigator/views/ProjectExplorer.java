package org.evilbit.navigator.views;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeRootData;

/*
 * Need to add "org.eclipse.ui.navigator" dependencies to required plug-ins
 * 
 * After adding "org.eclipse.ui.navigator.viewer" on the "extension" tab, you 
 * can see the message: "Eclipse no schema found for the 
 * 'org.eclipse.ui.navigator.viewer' extension point", then you need to install 
 * Eclipse SDK. You may not have the source code and developer documentation 
 * for the Eclipse platform, where the schema will be provided. From the 
 * Help menu, Install New Software wizard, install the Eclipse Platform SDK or 
 * the full Eclipse SDK from The Eclipse Projects Updates site.
 *
 */

public class ProjectExplorer extends CommonNavigator {
	public static final String ID = "CustomPlugin.views.ProjectExplorer";

	protected IAdaptable getInitialInput() {
		return new PropertiesTreeRootData();
	}
}
