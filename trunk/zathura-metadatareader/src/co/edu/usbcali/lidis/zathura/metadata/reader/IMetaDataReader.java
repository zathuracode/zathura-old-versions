package co.edu.usbcali.lidis.zathura.metadata.reader;

import co.edu.usbcali.lidis.zathura.metadata.model.MetaDataModel;
/**
 * 
 * @author diegomez
 * Basado en el codigo de jpa2Web
 *
 */
public interface IMetaDataReader {
	public MetaDataModel loadMetaDataModel(String path,String pckgName);
}