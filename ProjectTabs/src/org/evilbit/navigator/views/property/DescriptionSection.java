package org.evilbit.navigator.views.property;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

public class DescriptionSection extends AbstractPropertySection {

	public DescriptionSection() {
		// TODO Auto-generated constructor stub
	}

	public void createControls(Composite parent, TabbedPropertySheetPage aTabbedPropertySheetPage) {
		super.createControls(parent, aTabbedPropertySheetPage);
		Composite container = getWidgetFactory().createFlatFormComposite(parent);
		container.setLayout(new GridLayout(2, false));

		GridData nameData = new GridData(SWT.BEGINNING, SWT.FILL, true, true, 1, 1);
		GridData descriptionData = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		nameData.heightHint = 10;
		nameData.widthHint = 150;
		descriptionData.heightHint = 100;

		getWidgetFactory().createCLabel(container, "Add custom UI here...");

	}
}