package psl.shortcleaner.dictLoader;
/**
 * Class to load and use twitter abbreviation dictionary
 * @author puneet
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import psl.shortcleaner.utils.SimpleDictionaryLoader;

public class TwitterAbbreviationDictionary implements Dictionary {

	
	private Properties prop = new Properties();
	private static SimpleDictionaryLoader twitterDictonary = null;
	private InputStream input = null;
	 
	
	public TwitterAbbreviationDictionary() {
	}

	private void loadProperties()
	{
		try {
			input = new FileInputStream("properties/dictionary.properties");
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void loadDictionary(String dictionaryPath)
	{
		try {
			twitterDictonary = new SimpleDictionaryLoader();
			input = new FileInputStream(dictionaryPath);
			twitterDictonary.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getDictionaryValue(String text) {
		if(twitterDictonary == null)
		{
			loadProperties();
			String dictionaryPath = prop.getProperty(this.getClass().getSimpleName());
			loadDictionary(dictionaryPath);
		}
		String dictValue = twitterDictonary.getDictionaryValue(text.toLowerCase());
		if(dictValue ==null)
			return text;
		return dictValue;
	}

}
