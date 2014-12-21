package psl.shortcleaner;

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
 * 
 * @author Puneet Singh
 *
 */
public class ShortCleaner {
	/**
	 * @param shorttext   the text to clean
	 * @param checkSpelling    boolean true for spelling checking
	 * @return the {@code CleanTextBean}, filled for the consumption of further feature extractions.
	 */
	public CleanTextBean cleanEverything(String shorttext, boolean checkSpellings, boolean addTitle)
	{
		TwitterAbbreviationDictionary tad = new TwitterAbbreviationDictionary();
		SpellCheckDictionary scd = new SpellCheckDictionary();
		String shrttext = shorttext;
		CleanTextBean ctb = new CleanTextBean();
		ctb = CleanTextFeatureFiller.fill(shorttext,ctb);
		String url = getURLFromText(shrttext);
		String title  = "";
		if(url!=null&&addTitle)
		{
				title = TitleExtractor.getPageTitle(url);	
		}
		shrttext = shrttext+" "+title;
		shrttext = cleanCamelCasing(shrttext);
		shrttext = cleanRepeatingText(shrttext);
		shrttext = cleanAnythingOtherThanCharachters(shrttext);
		
		String b[] = SimpleTokenizer.tokenize(shrttext);
		
		for (int i=0;i<b.length;i++) {
			b[i]=tad.getDictionaryValue(b[i]);
		}
		shrttext = StringUtils.join(b," ");
		shrttext = cleanRepeatingText(shrttext);
		/*
		 * Some problem in the spelling checker so avoiding this right now
		 */
		if(checkSpellings)
		{
			b = SimpleTokenizer.tokenize(shrttext);
			for (int i=0;i<b.length;i++) {
				b[i]=scd.getDictionaryValue(b[i]);
			}
			shrttext = StringUtils.join(b," ");
		}
		ctb.setCleanText(shrttext);
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
