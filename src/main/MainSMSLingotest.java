package main;

import psl.shortcleaner.cleaners.SMSLingoCleaner;

public class MainSMSLingotest {
	public static void main(String[] args) {
		SMSLingoCleaner slc = new  SMSLingoCleaner();
		slc.setText("a");
		slc.getRawCleanText();
	}
}
