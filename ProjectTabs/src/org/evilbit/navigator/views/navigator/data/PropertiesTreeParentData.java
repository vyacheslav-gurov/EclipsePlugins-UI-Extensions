package org.evilbit.navigator.views.navigator.data;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

public class PropertiesTreeParentData extends PropertiesTreeData {

	private List<PropertiesTreeData> children;

	public PropertiesTreeParentData(String name, IFile file, IProject project) {
		super(name, file, project);
		children = new ArrayList<>();
	}

	public void addChild(PropertiesTreeData child) {
		children.add(child);
	}

	public void removeChild(PropertiesTreeData child) {
		children.remove(child);
	}

	public Object[] getChildren() {
		return this.children.toArray();
	}
}