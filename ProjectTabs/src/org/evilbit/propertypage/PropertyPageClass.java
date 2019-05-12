package org.evilbit.propertypage;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.QualifiedName;
import org.eclipse.jface.preference.PreferencePage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.dialogs.PropertyPage;

/*
 * Need to add "org.eclipse.core.resources" dependencies to required plug-ins
 * PropertyPage for Project Properties
 */

public class PropertyPageClass extends PropertyPage {

	private static final String PATH_TITLE = "Path:";
	private static final String OWNER_TITLE = "&Owner:";
	private static final String OWNER_PROPERTY = "OWNER";
	private static final String DEFAULT_OWNER = "EvilBit";

	private static final int TEXT_FIELD_WIDTH = 50;

	private Text ownerText;

	/**
	 * Constructor
	 */
	public PropertyPageClass() {
		super();
	}

	private Composite createDefaultComposite(Composite parent) {
		Composite composite = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		composite.setLayout(layout);

		GridData data = new GridData();
		data.verticalAlignment = GridData.FILL;
		data.horizontalAlignment = GridData.FILL;
		composite.setLayoutData(data);

		return composite;
	}

	private void addFirstSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		// Label for path field
		Label pathLabel = new Label(composite, SWT.NONE);
		pathLabel.setText(PATH_TITLE);

		// Path text field
		Text pathValueText = new Text(composite, SWT.WRAP | SWT.READ_ONLY);

		IAdaptable adaptable = getElement();
		if (adaptable.getAdapter(IResource.class) instanceof IResource) {
			IResource resource = (IResource) adaptable.getAdapter(IResource.class);
			pathValueText.setText(resource.getFullPath().toString());
		}
	}

	private void addSeparator(Composite parent) {
		Label separator = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gridData = new GridData();
		gridData.horizontalAlignment = GridData.FILL;
		gridData.grabExcessHorizontalSpace = true;
		separator.setLayoutData(gridData);
	}

	private void addSecondSection(Composite parent) {
		Composite composite = createDefaultComposite(parent);

		// Label for owner field
		Label ownerLabel = new Label(composite, SWT.NONE);
		ownerLabel.setText(OWNER_TITLE);

		// Owner text field
		ownerText = new Text(composite, SWT.SINGLE | SWT.BORDER);
		GridData gd = new GridData();
		gd.widthHint = convertWidthInCharsToPixels(TEXT_FIELD_WIDTH);
		ownerText.setLayoutData(gd);

		// Populate owner text field
		try {
			IAdaptable adaptable = getElement();
			if (adaptable.getAdapter(IResource.class) instanceof IResource) {
				IResource resource = (IResource) adaptable.getAdapter(IResource.class);
				String owner = resource.getPersistentProperty(new QualifiedName("", OWNER_PROPERTY));
				ownerText.setText((owner != null) ? owner : DEFAULT_OWNER);
			}

		} catch (CoreException e) {
			ownerText.setText(DEFAULT_OWNER);
		}
	}

	/**
	 * @see PreferencePage#createContents(Composite)
	 */
	protected Control createContents(Composite parent) {
		Composite composite = new Composite(parent, SWT.NONE);
		GridLayout layout = new GridLayout();
		composite.setLayout(layout);
		GridData data = new GridData(GridData.FILL);
		data.grabExcessHorizontalSpace = true;
		composite.setLayoutData(data);

		addFirstSection(composite);
		addSeparator(composite);
		addSecondSection(composite);
		return composite;
	}

	protected void performDefaults() {
		super.performDefaults();
		// Populate the owner text field with the default value
		ownerText.setText(DEFAULT_OWNER);
	}

	public boolean performOk() {
		// store the value in the owner text field
		try {
			IAdaptable adaptable = getElement();
			if (adaptable.getAdapter(IResource.class) instanceof IResource) {
				IResource resource = (IResource) adaptable.getAdapter(IResource.class);
				resource.setPersistentProperty(new QualifiedName("", OWNER_PROPERTY), ownerText.getText());
			}
		} catch (CoreException e) {
			return false;
		}
		return true;
	}

}