package org.evilbit.navigator.views.navigator;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;

public class NavigatorLabelProvider extends LabelProvider implements ILabelProvider, IDescriptionProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof PropertiesTreeData) {
			return ((PropertiesTreeData) element).getName();
		}
		return null;
	}

	@Override
	public Image getImage(Object element) {
		if (element instanceof PropertiesTreeData) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJS_INFO_TSK);
		}
		return null;
	}

	@Override
	public String getDescription(Object anElement) {
		// TODO Auto-generated method stub
		return "This is a tree data";
	}
}