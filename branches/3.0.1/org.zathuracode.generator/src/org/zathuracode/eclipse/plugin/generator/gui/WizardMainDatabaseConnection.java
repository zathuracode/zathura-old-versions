package org.zathuracode.eclipse.plugin.generator.gui;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.wizard.Wizard;
import org.zathuracode.eclipse.plugin.generator.ZathuraGeneratorActivator;
import org.zathuracode.eclipse.plugin.generator.utilities.ConnectionModel;
import org.zathuracode.eclipse.plugin.generator.utilities.ConnectionsUtils;
import org.zathuracode.swt.utilities.ResourceManager;


/**
 * Zathuracode Generator.
 *
 * @author Diego Armando Gomez Mosquera (dgomez@vortexbird.com)
 * @version 1.0
 * @see Wizard
 */
public class WizardMainDatabaseConnection extends Wizard {

	/** The wizard database connection. */
	private WizardPageDatabaseConnection wizardDatabaseConnection;

	/**
	 * The Constructor.
	 */
	public WizardMainDatabaseConnection() {
		super();
		setWindowTitle("Zathuracode Generator V3.0.1 - Powered By Vortexbird and UsbCali www.zathuracode.org");
		setDefaultPageImageDescriptor(ResourceManager.getPluginImageDescriptor(ZathuraGeneratorActivator.getDefault(), "icons/balvardi-Robotic7070.jpg"));
		wizardDatabaseConnection = new WizardPageDatabaseConnection();
	}

	/*
	 * 
	 * private Text txtConnectionURL; private Text txtUserName; private Text
	 * txtPassword; private Combo cmbDriverTemplate; private List listJARs;
	 * private Text txtDriverClassName; private Button btnTestDriver; private
	 * boolean testConnection=false; private Text txtDriverName;
	 */
	/**
	 * The Constructor.
	 *
	 * @param connectionName the connection name
	 */
	public WizardMainDatabaseConnection(String connectionName) {
		super();
		setWindowTitle("Zathuracode Generator V3.0.1 - Powered By Vortexbird and UsbCali www.zathuracode.org");
		setDefaultPageImageDescriptor(ResourceManager.getPluginImageDescriptor(ZathuraGeneratorActivator.getDefault(), "icons/balvardi-Robotic7070.jpg"));
		ConnectionModel connectionModel = ConnectionsUtils.getTheZathuraConnectionModel(connectionName);

		wizardDatabaseConnection = new WizardPageDatabaseConnection();
		wizardDatabaseConnection.setDriverTemplate(connectionModel.getDriverTemplate());
		wizardDatabaseConnection.setName(connectionModel.getName());
		wizardDatabaseConnection.setUrl(connectionModel.getUrl());
		wizardDatabaseConnection.setUser(connectionModel.getUser());
		wizardDatabaseConnection.setPassword(connectionModel.getPassword());
		wizardDatabaseConnection.setDriverClassName(connectionModel.getDriverClassName());
		wizardDatabaseConnection.setJarPath(connectionModel.getJarPath());
		wizardDatabaseConnection.setTitle("Edit Database Connection");
		wizardDatabaseConnection.setDescription("Edit a connection driver");

	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#addPages()
	 */
	@Override
	public void addPages() {

		addPage(wizardDatabaseConnection);
	}

	/* (non-Javadoc)
	 * @see org.eclipse.jface.wizard.Wizard#performFinish()
	 */
	@Override
	public boolean performFinish() {
		try {
			ConnectionModel connectionModel = new ConnectionModel(wizardDatabaseConnection.getCmbDriverTemplate().getText(), wizardDatabaseConnection
					.getTxtDriverName().getText(), wizardDatabaseConnection.getTxtConnectionURL().getText(), wizardDatabaseConnection.getTxtUserName()
					.getText(), wizardDatabaseConnection.getTxtPassword().getText(), wizardDatabaseConnection.getTxtDriverClassName().getText(),
					wizardDatabaseConnection.getListJARs().getItem(0));

			ConnectionsUtils.saveConnectionModel(connectionModel);
			WizardPageSelectDBConnection.loadConnections();
		} catch (Exception e) {
			MessageDialog.openError(getShell(), "Error", e.getMessage());
			return false;
		}

		return true;
	}

	/**
	 * Gets the wizard database connection.
	 *
	 * @return the wizard database connection
	 */
	public WizardPageDatabaseConnection getWizardDatabaseConnection() {
		return wizardDatabaseConnection;
	}

	/**
	 * Sets the wizard database connection.
	 *
	 * @param wizardDatabaseConnection the wizard database connection
	 */
	public void setWizardDatabaseConnection(WizardPageDatabaseConnection wizardDatabaseConnection) {
		this.wizardDatabaseConnection = wizardDatabaseConnection;
	}

}