package org.evilbit.navigator.views.navigator;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;

public class NavigatorContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		// if the parent element is IFile, add a PropertiesTreeData as child node
		if (parentElement instanceof IFile) {
			IFile file = (IFile) parentElement;
			String name = file.getName() + "[Tree Data]";
			PropertiesTreeData propertiesTreeData = new PropertiesTreeData(name, file, file.getProject());
			return new Object[] { propertiesTreeData };
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof IFile) {
			return true;
		}
		return false;
	}
}