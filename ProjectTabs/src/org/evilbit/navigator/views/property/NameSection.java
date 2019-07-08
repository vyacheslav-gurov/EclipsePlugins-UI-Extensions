package org.evilbit.navigator.views.property;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.views.properties.tabbed.AbstractPropertySection;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;
import org.evilbit.navigator.views.ProjectExplorer;
import org.evilbit.navigator.views.navigator.data.PropertiesTreeData;

public class NameSection extends AbstractPropertySection {

	private Text nameText;
	private PropertiesTreeData data;
	private ModifyListener nameListener = new ModifyListener() {
		@Override
		public void modifyText(ModifyEvent e) {
			// TODO Auto-generated method stub
			data.setName(nameText.getText());
			IViewPart navigator = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.findView(ProjectExplorer.ID);//find the navigator
			((ProjectExplorer) navigator).getCommonViewer().refresh(data);
		}
	};

	public NameSection() {
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

		getWidgetFactory().createCLabel(container, "Name:");
		nameText = getWidgetFactory().createText(container, "");
		nameText.setLayoutData(nameData);
	}

	public void setInput(IWorkbenchPart part, ISelection selection) {
		super.setInput(part, selection);
		if (part instanceof ProjectExplorer) {
			Object object = ((IStructuredSelection) selection).getFirstElement();
			if (object instanceof PropertiesTreeData) {
				this.data = (PropertiesTreeData) object;
			}
		}
	}

	public void refresh() {
		nameText.removeModifyListener(nameListener);
		nameText.setText(data.getName());
		nameText.addModifyListener(nameListener);
	}
}