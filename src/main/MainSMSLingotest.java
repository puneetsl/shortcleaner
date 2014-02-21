package main;

import psl.shortcleaner.dictLoader.TwitterAbbreviationDictionary;


public class MainSMSLingotest {
	public static void main(String[] args){
		TwitterAbbreviationDictionary tad = new TwitterAbbreviationDictionary();
		System.out.println(tad.getDictionaryValue("lmao"));
		System.out.println(tad.getDictionaryValue("wtf"));
		System.out.println(tad.getDictionaryValue("fts"));
		System.out.println(tad.getDictionaryValue("lmao"));
	}
}
