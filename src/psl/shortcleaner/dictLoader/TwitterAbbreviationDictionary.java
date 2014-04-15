package psl.shortcleaner.dictLoader;
/**
 * Class to load and use twitter abbreviation dictionary
 * @author puneet
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import psl.shortcleaner.utils.PropertiesInormation;
import psl.shortcleaner.utils.SimpleDictionaryLoader;

public class TwitterAbbreviationDictionary implements Dictionary {

	
	private static SimpleDictionaryLoader twitterDictonary = null;
	private InputStream input = null;
	 
	
	public TwitterAbbreviationDictionary() {
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
			String dictionaryPath = PropertiesInormation.getProperties().getProperty(this.getClass().getSimpleName());
			loadDictionary(dictionaryPath);
		}
		String dictValue = twitterDictonary.getDictionaryValue(text.toLowerCase());
		if(dictValue ==null)
			return text;
		return dictValue;
	}

}
