package main;


import java.io.IOException;

import psl.shortcleaner.*;

public class MainLingotest {
	public static void main(String[] args) throws IOException{
		ShortCleaner sc = new ShortCleaner();
		System.out.println(sc.cleanEverything("#ShahRukhKhan http://t.co/0Y4GCzpWzL",false,false).getCleanText());
	}
}