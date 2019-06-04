package org.evilbit.navigator.filters;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;

public class NavigatorFilter extends ViewerFilter {

	public NavigatorFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean select(Viewer viewer, Object parentElement, Object element) {
		// TODO Auto-generated method stub
		if (element instanceof IProject) {
			IProject prj = (IProject) element;
			try {
				if (prj.hasNature("org.eclipse.jdt.core.javanature")) {//org.eclipse.jdt.core.javanature is the nature id of Java project
					return false;
				}
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

}