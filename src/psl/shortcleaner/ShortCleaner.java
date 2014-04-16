package psl.shortcleaner;

import psl.shortcleaner.dictLoader.SpellCheckDictionary;
import psl.shortcleaner.dictLoader.TwitterAbbreviationDictionary;
import psl.shortcleaner.tokenizer.SimpleTokenizer;
import psl.shortcleaner.utils.StringUtils;

/**
 * Making this class for temporary usage just to move fast towards the tlassify-gender project
 * TODO: have to clean this 
 * @author Puneet
 *
 */
public class ShortCleaner {
	/**
	 * 
	 * @return
	 */
	public String cleanEverything(String shorttext, boolean checkSpellings)
	{
		TwitterAbbreviationDictionary tad = new TwitterAbbreviationDictionary();
		SpellCheckDictionary scd = new SpellCheckDictionary();
		String a = shorttext;
		a = cleanCamelCasing(a);
		a = cleanRepeatingText(a);
		a = cleanAnythingOtherThanCharachters(a);
		
		String b[] = SimpleTokenizer.tokenize(a);
		
		for (int i=0;i<b.length;i++) {
			b[i]=tad.getDictionaryValue(b[i]);
		}
		a = StringUtils.join(b," ");
		a = cleanRepeatingText(a);
		/*
		 * Some problem in the spelling checker so avoiding this right now
		 */
		if(checkSpellings)
		{
			b = SimpleTokenizer.tokenize(a);
			for (int i=0;i<b.length;i++) {
				b[i]=scd.getDictionaryValue(b[i]);
			}
			a = StringUtils.join(b," ");
		}
		return a;

	}
	private String cleanAnythingOtherThanCharachters(String textToClean)
	{
		return textToClean.replaceAll("[^a-zA-Z' ]", " ");
	}
	private String cleanCamelCasing(String textToClean)
	{
		return textToClean.replaceAll("([a-z])([A-Z])", "$1 $2");
	}
	private String cleanRepeatingText(String textToClean)
	{
		return textToClean.replaceAll("(.)\\1{2,}+","$1");
	}
}
