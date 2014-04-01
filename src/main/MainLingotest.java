package main;


import psl.shortcleaner.utils.StringUtils;
import psl.shortcleaner.dictLoader.SpellCheckDictionary;
import psl.shortcleaner.dictLoader.TwitterAbbreviationDictionary;
import psl.shortcleaner.tokenizer.SimpleTokenizer;

public class MainLingotest {
	public static void main(String[] args){
		/**
		 * TODO: Implement Controller 
		 */
		TwitterAbbreviationDictionary tad = new TwitterAbbreviationDictionary();
		SpellCheckDictionary scd = new SpellCheckDictionary();
		String a = "plz lemme noe wen u get thr";
		String b[] = SimpleTokenizer.tokenize(a);
		for (int i=0;i<b.length;i++) {
			b[i]=tad.getDictionaryValue(b[i]);
		}
		a = StringUtils.join(b," ");
		b = SimpleTokenizer.tokenize(a);
		for (int i=0;i<b.length;i++) {
			b[i]=scd.getDictionaryValue(b[i]);
		}
		System.out.println(StringUtils.join(b," "));

	}
}