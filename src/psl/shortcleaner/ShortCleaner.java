package psl.shortcleaner;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import psl.shortcleaner.bean.CleanTextBean;
import psl.shortcleaner.dictLoader.SpellCheckDictionary;
import psl.shortcleaner.dictLoader.TwitterAbbreviationDictionary;
import psl.shortcleaner.tokenizer.SimpleTokenizer;
import psl.shortcleaner.utils.CleanTextFeatureFiller;
import psl.shortcleaner.utils.StringUtils;
import psl.shortcleaner.utils.TitleExtractor;

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
	public CleanTextBean cleanEverything(String shorttext, boolean checkSpellings)
	{
		TwitterAbbreviationDictionary tad = new TwitterAbbreviationDictionary();
		SpellCheckDictionary scd = new SpellCheckDictionary();
		String a = shorttext;
		CleanTextBean ctb = new CleanTextBean();
		ctb = CleanTextFeatureFiller.fill(shorttext,ctb);
		String url = getURLFromText(a);
		String title  = "";
		if(url!=null)
		{
			try {
				title = TitleExtractor.getPageTitle(url);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		a = a+" "+title;
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
		ctb.setCleanText(a);
		return ctb;//adding title to the cleaned string

	}
	private String getURLFromText(String a) {
		/*
		 * This function could be used to get URLS and works most of the times, 
		 * in case this doesn't work it would any way would not affect the final feature extraction process 
		 */
		Pattern p = Pattern.compile("\\b((?:https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])",
        Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		Matcher m = p.matcher(a);
		if(m.find())
		{
			return m.group(1).replaceAll("[\\s\\<>]+", " ").trim();
		}
		return null;
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
