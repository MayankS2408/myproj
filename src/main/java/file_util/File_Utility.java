package file_util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {

	public String fetchdatafrompropfile(String key) throws IOException {

		FileInputStream file = new FileInputStream("./src/test/resources/config.properties");
		Properties property = new Properties();
		property.load(file);
		return property.getProperty(key);

	}
}
