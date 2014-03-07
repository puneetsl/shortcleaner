package main;

import psl.shortcleaner.utils.StringUtils;

import psl.shortcleaner.dictLoader.TwitterAbbreviationDictionary;
import psl.shortcleaner.tokenizer.SimpleTokenizer;

public class MainSMSLingotest {
	public static void main(String[] args){
		TwitterAbbreviationDictionary tad = new TwitterAbbreviationDictionary();
		String a = "Lol omg this is so funny lmao";
		String b[] = SimpleTokenizer.tokenize(a);
		for (int i=0;i<b.length;i++) {
			b[i]=tad.getDictionaryValue(b[i]);
		}
		System.out.println(StringUtils.join(b," "));
	}
}
