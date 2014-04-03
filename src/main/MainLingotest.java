package main;


import psl.shortcleaner.*;
import psl.shortcleaner.dictLoader.SpellCheckDictionary;

public class MainLingotest {
	public static void main(String[] args){
		ShortCleaner sc = new ShortCleaner();
		System.out.println(sc.cleanEverything("#@ThatGing07 @WinthropDSU I don't condone shout outs that spell Thomson wrong. #INeedTheCash #shoutusoutforcafecash"));
		SpellCheckDictionary scd = new SpellCheckDictionary();
		System.out.println(scd.getDictionaryValue("Winthrop"));
	}
}