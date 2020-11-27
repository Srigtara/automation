package utils;

import java.io.FileInputStream;
import java.util.Properties;

/*
 * This class loads the properties files which contains data which is used
 * across the application
 */

public class ReadPropertyFile {

	public static Properties prop;

	public ReadPropertyFile() {
		try {
			prop = new Properties();
			String currentDir = System.getProperty("user.dir");
			FileInputStream fis1 = new FileInputStream(currentDir + Constants.PATH_TO_CONFIG_FILE);
			FileInputStream fis2 = new FileInputStream(currentDir + Constants.PATH_TO_TEST_DATA_FILE);
			prop.load(fis1);
			prop.load(fis2);
		} catch (Exception e) {
			System.out.println("I/O Exception caught.");
		}
	}

	public String getProperty(String key) {
		return prop.getProperty(key);
	}

}
