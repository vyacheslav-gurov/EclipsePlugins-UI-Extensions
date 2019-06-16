package org.evilbit.navigator.views.navigator.data;

import java.util.UUID;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;

public class PropertiesTreeData {
	// TODO Auto-generated constructor stub
	private String name;
	private IFile file;
	private IProject project;
	private String ID = UUID.randomUUID().toString();// make the object unique

	public PropertiesTreeData(String name, IFile file, IProject project) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.file = file;
		this.project = project;
	}

	public String getID() {
		return this.ID;
	}

	public IFile getFile() {
		return file;
	}

	public IProject getProject() {
		return this.project;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Eclispe will use Set to save the node shown on the navigator. Thus, it is
	 * necessary to implement this method.
	 */
	public int hashCode() {
		return ID.hashCode();
	}

	/**
	 * The inner code will call this method to find the exact node when the user
	 * want to make update to the navigator
	 */
	public boolean equals(Object obj) {
		return obj instanceof PropertiesTreeData && ((PropertiesTreeData) obj).getID().equals(ID);
	}
}