package main;


import java.io.IOException;

import psl.shortcleaner.*;
import psl.shortcleaner.utils.TitleExtractor;

public class MainLingotest {
	public static void main(String[] args) throws IOException{
		ShortCleaner sc = new ShortCleaner();
		System.out.println(sc.cleanEverything("#ShahRukhKhan http://t.co/0Y4GCzpWzL",false));
	}
}