/**
 * This class cleans text using a netLingo dictionary
 * e.g. "ASAP" would be converted to "as soon as possible" 
 */
package psl.shortcleaner.cleaners;

import psl.shortcleaner.exceptions.NoTextException;

/**
 * Check ShortCleaner.java for function usage
 * @author puneet
 * 
 */
public class SMSLingoCleaner implements ShortCleaner {

	private String dirtyText=null;
	private String cleanRawText=null; 
	private String cleanTaggedText=null;
	public SMSLingoCleaner() {
		dirtyText = "";	
	}
	public void setText(String shortText) {
		dirtyText = shortText;
	}

	
	public String getRawCleanText() {
		if(dirtyText == null || dirtyText.equals(""))
		{			
				throw new NoTextException();
		}
		return cleanRawText;
	}

	
	public String getTaggedText() {
		if(dirtyText == null || dirtyText.equals(""))
		{			
				throw new NoTextException();
		}
		return cleanTaggedText;
	}

}
