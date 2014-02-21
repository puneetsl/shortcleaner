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
public class TwitterAbbreviationCleaner implements ShortCleaner {

	private String dirtyText=null;
	private String cleanRawText=null; 
	private String cleanTaggedText=null;
	public TwitterAbbreviationCleaner() {
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

	
	public String getTaggedCleanText() {
		if(dirtyText == null || dirtyText.equals(""))
		{			
				throw new NoTextException();
		}
		return cleanTaggedText;
	}

}
