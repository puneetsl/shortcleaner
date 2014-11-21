package main;


import java.io.IOException;

import psl.shortcleaner.*;
import psl.shortcleaner.utils.TitleExtractor;

public class MainLingotest {
	public static void main(String[] args){
		ShortCleaner sc = new ShortCleaner();
		
		System.out.println(sc.cleanEverything("#ShahRukhKhan ahead of #SalmanKhan and #AamirKhan on Twitter, crosses 10 million followers http://dnai.in/csuH ",false));
	}
}