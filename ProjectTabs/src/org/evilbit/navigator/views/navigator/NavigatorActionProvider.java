package org.evilbit.navigator.views.navigator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.navigator.CommonActionProvider;
import org.eclipse.ui.navigator.ICommonActionExtensionSite;
import org.eclipse.ui.navigator.ICommonViewerSite;
import org.eclipse.ui.navigator.ICommonViewerWorkbenchSite;

public class NavigatorActionProvider extends CommonActionProvider {

	public final static String ACTION_ADD = "group.add";

	private List<Action> actionList;
	private Map<Action, String> actionGroup;

	public NavigatorActionProvider() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ICommonActionExtensionSite aSite) {
		ICommonViewerSite viewSite = aSite.getViewSite();
		if (viewSite instanceof ICommonViewerWorkbenchSite) {
			ICommonViewerWorkbenchSite workbenchSite = (ICommonViewerWorkbenchSite) viewSite;

			actionList = new ArrayList<Action>();
			actionGroup = new HashMap<Action, String>();

			Action addNodeAction = new AddNodeAction(workbenchSite.getPage(), workbenchSite.getSelectionProvider());
			actionList.add(addNodeAction);

			actionGroup.put(addNodeAction, ACTION_ADD);
		}
	}

	@Override
	public void fillContextMenu(IMenuManager menu) {
		for (Action act : actionList) {
			act.setEnabled(act.isEnabled());
			menu.appendToGroup(actionGroup.get(act).toString(), act);
		}
	}
}