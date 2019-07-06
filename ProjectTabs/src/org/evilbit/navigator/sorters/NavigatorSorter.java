package org.evilbit.navigator.sorters;

import java.text.Collator;

import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerComparator;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;

public class NavigatorSorter extends ViewerComparator {

	public NavigatorSorter() {
		// TODO Auto-generated constructor stub
	}

	public NavigatorSorter(Collator collator) {
		super(collator);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(Viewer viewer, Object e1, Object e2) {
		int result = -1;
		if (e1 instanceof PropertiesTreeData && e2 instanceof PropertiesTreeData) {
			PropertiesTreeData p1 = (PropertiesTreeData) e1;
			PropertiesTreeData p2 = (PropertiesTreeData) e2;
			int numInP1 = Integer.parseInt(p1.getName().replaceAll("[\\D]", ""));
			int numInP2 = Integer.parseInt(p2.getName().replaceAll("[\\D]", ""));

			result = numInP1 < numInP2 ? 1 : -1;
		}
		return result;
	}
}