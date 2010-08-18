package co.edu.usbcali.lidis.zathura.reverse.test;

import java.util.List;
import java.util.Properties;

import co.edu.usbcali.lidis.zathura.reverse.createPojos.IZathuraReverseMappingTool;
import co.edu.usbcali.lidis.zathura.reverse.createPojos.ZathuraReverseMappingTool;
import co.edu.usbcali.lidis.zathura.reverse.utilities.ReverseUtil;

public class TestZathura_ReverseMappingTool {

	public static void main(String[] args) {
		Properties connectionProperties = new Properties();

		// String connectionDriverClass = "com.mysql.jdbc.Driver";
		// String connectionUrl = "jdbc:mysql://localhost:3306/mascotas";
		// String defaultSchema = "mascotas";
		// String connectionUsername = "root";
		// String connectionPassword = "root";
		// String companyDomainName = "co.edu.usbcali.mascotas";
		// String connectionDriverJarPath =
		// "E:/WORKSPACE/mascotas/WebRoot/WEB-INF/lib/mysql-connector-java-3[1].1.12-bin.jar";
		// String destinationDirectory = "E:/WORKSPACE/mascotas/src/";
		// String matchSchemaForTables = null;
		// List<String> tablesList = null;

		// String connectionDriverClass = "com.mysql.jdbc.Driver";
		// String connectionUrl = "jdbc:mysql://localhost:3306/tlpj";
		// String defaultSchema = "tlpj";
		// String connectionUsername = "root";
		// String connectionPassword = "root";
		// String companyDomainName = "com.tlp.tlpj";
		// String connectionDriverJarPath =
		// "E:/WORK(New)/tlpj/WebRoot/WEB-INF/lib/mysql-connector-java-5.1.5-bin";
		// String connectionDriverJarPath =
		// "E:/WORK(New)/tlpj/WebRoot/WEB-INF/lib/mysql-connector-java-3[1].1.12-bin.jar";
		// String destinationDirectory = "E:/WORK(New)/tlpj/src/";
		// String matchSchemaForTables = null;
		// List<String> tablesList = null;
		// Boolean makeItXml = false;

		String connectionDriverClass = "oracle.jdbc.driver.OracleDriver";
		String connectionUrl = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String defaultSchema = null;
		String connectionUsername = "PA01";
		String connectionPassword = "root";
		String companyDomainName = "org.cgiar.ciat.pa2";
		String connectionDriverJarPath = "E:/WORK(New)/pa/WebRoot/WEB-INF/lib/ojdbc14.jar";
		String destinationDirectory = "E:/WORK(New)/pa/src/";
		String matchSchemaForTables = "PA01";
		List<String> tablesList = ReverseUtil.fillTableList();
		Boolean makeItXml = false;

		connectionProperties
				.put("connectionDriverClass", connectionDriverClass);
		connectionProperties.put("connectionUrl", connectionUrl);
		connectionProperties.put("defaultSchema", defaultSchema == null ? ""
				: defaultSchema);
		connectionProperties.put("connectionUsername", connectionUsername);
		connectionProperties.put("connectionPassword", connectionPassword);
		connectionProperties.put("companyDomainName", companyDomainName);
		connectionProperties.put("matchSchemaForTables",
				matchSchemaForTables == null ? "" : matchSchemaForTables);

		connectionProperties.put("connectionDriverJarPath",
				connectionDriverJarPath);

		connectionProperties.put("destinationDirectory", destinationDirectory);

		connectionProperties.put("makeItXml", makeItXml == true ? "True"
				: false);

		ReverseUtil.setFullPath(ReverseUtil.projectPathInConsole());

		IZathuraReverseMappingTool mappingTool = new ZathuraReverseMappingTool();
		mappingTool.makePojos(connectionProperties, tablesList);

	}

}