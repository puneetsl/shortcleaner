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
public class TwitterAbbreviationCleaner implements Cleaner {

	private String dirtyText[]=null;
	private String cleanRawText[]=null; 
	//private String cleanTaggedText[]=null;
	public TwitterAbbreviationCleaner() {
			
	}
	public void setText(String[] shortTextTokens) {
		dirtyText = shortTextTokens;
	}

	
	public String[] getRawCleanText() {
		if(dirtyText == null || dirtyText.equals(""))
		{			
				throw new NoTextException();
		}
		
		return cleanRawText;
	}
}
