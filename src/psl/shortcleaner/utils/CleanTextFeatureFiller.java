package psl.shortcleaner.utils;

import java.util.HashMap;

import psl.shortcleaner.bean.CleanTextBean;

public class CleanTextFeatureFiller {
	public static CleanTextBean fill(String shortText, CleanTextBean ctb)
	{
		//Filling features extracted from the text
		ctb.setEmoticons(Smilies.getSmileys(shortText));
		ctb.setDots(StringUtils.countOf(shortText, "."));
		ctb.setExclaimations(StringUtils.countOf(shortText, "!"));
		ctb.setHashTags(StringUtils.countOf(shortText, "#"));
		ctb.setLinkCount(StringUtils.countOf(shortText, "http"));
		ctb.setReferences(StringUtils.countOf(shortText, "@"));
		ctb.setRTcount(shortText.substring(0,3).equals("RT ")?1:0);
		ctb.setPunctuationCount(StringUtils.countOf(shortText, ",")+StringUtils.countOf(shortText, ";")
				+StringUtils.countOf(shortText, "?")+StringUtils.countOf(shortText, ":")
				);
		return ctb;
	}
}
