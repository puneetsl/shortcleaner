package psl.shortcleaner.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesInormation {
	public static Properties getProperties()
	{
		InputStream input = null;
		Properties prop= new Properties();
			try {
				input = new FileInputStream("properties/dictionary.properties");
				prop.load(input);
			} catch (IOException e) {
				e.printStackTrace();
			}
		return prop;
	}
}
