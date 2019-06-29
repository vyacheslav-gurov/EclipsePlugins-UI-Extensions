package org.evilbit.navigator.filters;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeRootData;

public class NavigatorFilter extends ViewerFilter {

	public NavigatorFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub
		if (element instanceof PropertiesTreeData) {
			return true;
		}
		if (element instanceof PropertiesTreeRootData) {
			return true;
		}
		return false;
	}

}