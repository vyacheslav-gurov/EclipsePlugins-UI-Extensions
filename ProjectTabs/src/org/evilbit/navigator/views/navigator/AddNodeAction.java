package org.evilbit.navigator.views.navigator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.CommonNavigator;
import org.evilbit.navigator.views.ProjectExplorer;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeParentData;

public class AddNodeAction extends Action {
	private IWorkbenchPage page;
	private PropertiesTreeParentData data;
	private ISelectionProvider selectionProvider;

	public AddNodeAction(IWorkbenchPage p, ISelectionProvider selectionProvider) {
		setText("Add A Child Node"); //name of action
		this.page = p;
		this.selectionProvider = selectionProvider;
	}

	@Override
	public boolean isEnabled() {
		ISelection selection = selectionProvider.getSelection();

		if (!selection.isEmpty()) {
			IStructuredSelection sSelection = (IStructuredSelection) selection;
			if (sSelection.getFirstElement() instanceof PropertiesTreeParentData) {
				data = (PropertiesTreeParentData) sSelection.getFirstElement();
				return true;
			}
		}

		return false;
	}

	@Override
	public void run() {
		PropertiesTreeData childNode = new PropertiesTreeData("new child", null, data.getProject());
		data.addChild(childNode);
		//refresh the navigator
		CommonNavigator navigator = (CommonNavigator) page.findView(ProjectExplorer.ID);
		navigator.getCommonViewer().refresh(data);
	}
}
