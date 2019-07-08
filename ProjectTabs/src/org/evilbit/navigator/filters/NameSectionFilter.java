package org.evilbit.navigator.filters;

import org.eclipse.jface.viewers.IFilter;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;

public class NameSectionFilter implements IFilter {

	@Override
	public boolean select(Object toTest) {
		// TODO Auto-generated method stub
		if (toTest instanceof PropertiesTreeData) {
			return true;
		}
		return false;
	}

}
