package main;

import psl.shortcleaner.cleaners.TwitterAbbreviationCleaner;

public class MainSMSLingotest {
	public static void main(String[] args) {
		TwitterAbbreviationCleaner slc = new  TwitterAbbreviationCleaner();
		slc.setText("a");
		slc.getRawCleanText();
	}
}
