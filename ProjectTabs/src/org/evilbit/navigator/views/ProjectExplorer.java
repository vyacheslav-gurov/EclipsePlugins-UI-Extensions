package org.evilbit.navigator.views;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.ui.navigator.CommonNavigator;
import org.eclipse.ui.views.properties.IPropertySheetPage;
import org.eclipse.ui.views.properties.tabbed.ITabbedPropertySheetPageContributor;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
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

public class ProjectExplorer extends CommonNavigator implements ITabbedPropertySheetPageContributor {
	public static final String ID = "org.evilbit.navigator.views.ProjectExplorerId";

	@Override
	protected IAdaptable getInitialInput() {
		return new PropertiesTreeRootData();
	}

	@Override
	public String getContributorId() {
		return getSite().getId();
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
		super.getAdapter(adapter);
		if (adapter == IPropertySheetPage.class)
			return new TabbedPropertySheetPage(this);
		return super.getAdapter(adapter);
	}
}
