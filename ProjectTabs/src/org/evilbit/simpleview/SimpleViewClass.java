package org.evilbit.simpleview;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.ViewPart;

public class SimpleViewClass extends ViewPart {
	public static final String ID = "CustomPlugin.views.ExampleView1";

	@Override
	public void createPartControl(Composite parent) {
		Text text = new Text(parent, SWT.BORDER);
		text.setText("Hello View");
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
	}
}
