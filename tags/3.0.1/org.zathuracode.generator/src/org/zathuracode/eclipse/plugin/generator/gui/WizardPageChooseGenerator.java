package org.zathuracode.eclipse.plugin.generator.gui;

import java.util.HashMap;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.browser.Browser;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.List;
import org.zathuracode.eclipse.plugin.generator.utilities.EclipseGeneratorUtil;
import org.zathuracode.generator.factory.ZathuraGeneratorFactory;
import org.zathuracode.generator.model.GeneratorModel;


// TODO: Auto-generated Javadoc
/**
 * Zathura Generator.
 *
 * @author Diego Armando Gomez Mosquera (dgomez@vortexbird.com)
 * @version 1.0
 * @see WizardPage
 */
public class WizardPageChooseGenerator extends WizardPage {

	/** The list generators. */
	private List listGenerators;
	
	/** The bwr description. */
	private Browser bwrDescription;

	// Load the zathura Generators names
	/** The generators. */
	private HashMap<String, GeneratorModel> theGenerators = ZathuraGeneratorFactory.getTheZathuraGenerators();

	/**
	 * Create the wizard.
	 */
	public WizardPageChooseGenerator() {
		super("wizardPage");
		setTitle("Zathura Java Code Generator");
		setDescription("Generate Java Application based on Open Standards and JavaEE Design Patterns");
		// setImageDescriptor(ResourceManager.getPluginImageDescriptor(ZathuraGeneratorActivator.getDefault(),
		// "icons/balvardi-Robotic7070.png"));
		setPageComplete(false);
	}

	/**
	 * Create contents of the wizard.
	 *
	 * @param parent the parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		//
		setControl(container);

		final Group generatorChoiseGroup = new Group(container, SWT.NONE);
		generatorChoiseGroup.setText("Choose Generator");
		generatorChoiseGroup.setBounds(10, 10, 583, 281);

		listGenerators = new List(generatorChoiseGroup, SWT.BORDER);
		listGenerators.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				String architectureSelected = (listGenerators.getSelection()[0]);
				String architectureName = ZathuraGeneratorFactory.getGeneratorNameForGuiName(architectureSelected);
				EclipseGeneratorUtil.zathuraGeneratorName = architectureName;
				GeneratorModel generatorModel = theGenerators.get(architectureName);
				if (generatorModel != null) {
					bwrDescription.setText(generatorModel.getDescription());
					setPageComplete(true);
				}
			}
		});
		listGenerators.setBounds(10, 28, 203, 243);

		bwrDescription = new Browser(generatorChoiseGroup, SWT.NONE);
		bwrDescription.setBounds(219, 28, 354, 243);
		loadListGenerators();
	}

	/**
	 * Load list generators.
	 */
	public void loadListGenerators() {
		if (listGenerators != null) {
			listGenerators.removeAll();
			for (GeneratorModel generatorModel : theGenerators.values()) {
				if (EclipseGeneratorUtil.makeItXml == true && generatorModel.getPersistence().equals("hibernateCore") == true) {
					listGenerators.add(generatorModel.getGuiName());
				} else if (EclipseGeneratorUtil.makeItXml == false && generatorModel.getPersistence().equals("jpa") == true) {
					listGenerators.add(generatorModel.getGuiName());
				}

			}
		}
		if (bwrDescription != null) {
			bwrDescription.setText("");
		}
	}

}