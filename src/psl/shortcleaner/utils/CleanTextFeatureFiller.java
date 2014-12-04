package psl.shortcleaner.utils;

import java.util.HashMap;

import psl.shortcleaner.bean.CleanTextBean;

public class CleanTextFeatureFiller {
	public static CleanTextBean fill(String shortText, CleanTextBean ctb)
	{
		
		
		return ctb;
	}
	public static HashMap<String,Integer> getSmileys(String text)
	{
		HashMap<Integer, String> smileys ;
		HashMap<String, String> textSmileys ;
		smileys = new HashMap<Integer, String>();
		textSmileys = new HashMap<String, String>();
		textSmileys.put(":)", "happy");
		textSmileys.put(":(", "sad");
		textSmileys.put(":D", "happy");
		textSmileys.put(":|", "indifferent");
		textSmileys.put(";)", "naughty");
		textSmileys.put("<3", "love ");
		
		smileys.put("😀".codePointAt(0),"happy");
		smileys.put("😃".codePointAt(0),"happy");
		smileys.put("😄".codePointAt(0),"happy");
		smileys.put("☺".codePointAt(0),"happy");
		smileys.put("😊".codePointAt(0),"happy");
		smileys.put("😊".codePointAt(0),"happy");
		smileys.put("😜".codePointAt(0),"naughty");
		smileys.put("😝".codePointAt(0),"naughty");
		smileys.put("😛".codePointAt(0),"naughty");
		smileys.put("😁".codePointAt(0),"naughty");
		smileys.put("😉".codePointAt(0),"naughty");
		smileys.put("😔".codePointAt(0),"sad");
		smileys.put("😒".codePointAt(0),"sad");
		smileys.put("😞".codePointAt(0),"sad");
		smileys.put("😣".codePointAt(0),"sad");
		smileys.put("😢".codePointAt(0),"sad");
		smileys.put("😭".codePointAt(0),"sad");
		smileys.put("😪".codePointAt(0),"sad");
		smileys.put("😥".codePointAt(0),"sad");
		smileys.put("😰".codePointAt(0),"sad");
		smileys.put("😓".codePointAt(0),"sad");
		smileys.put("😩".codePointAt(0),"sad");
		smileys.put("😫".codePointAt(0),"sad");
		smileys.put("😠".codePointAt(0),"angry");
		smileys.put("😡".codePointAt(0),"angry");
		smileys.put("😤".codePointAt(0),"angry");
		smileys.put("😵".codePointAt(0),"surprised");
		smileys.put("😲".codePointAt(0),"surprised");
		smileys.put("😦".codePointAt(0),"surprised");
		smileys.put("😧".codePointAt(0),"surprised");
		smileys.put("😳".codePointAt(0),"surprised");
		smileys.put("😮".codePointAt(0),"surprised");
		smileys.put("😯".codePointAt(0),"surprised");
		smileys.put("😘".codePointAt(0),"love");
		smileys.put("😙".codePointAt(0),"love");
		smileys.put("😗".codePointAt(0),"love");
		smileys.put("😚".codePointAt(0),"love");
		HashMap<String,Integer> smileyCount =  new HashMap<String,Integer>();
		for(int i =0 ;i< text.length() ; i++)
		{
			if(smileys.containsKey(text.codePointAt(i)))
			{
				if(smileyCount.containsKey(smileys.get(text.codePointAt(i))))
				{	
					int count  =  smileyCount.get(smileys.get(text.codePointAt(i)));
					smileyCount.put(smileys.get(text.codePointAt(i)), count+1);
				}
				else
				{
					smileyCount.put(smileys.get(text.codePointAt(i)), 1);
				}
			}
		}
		for(int i =0 ;i< text.length()-1 ; i++)
		{
			System.out.println(text.substring(i,i+2));
			if(textSmileys.containsKey(text.substring(i, i+2)))
			{
				System.out.println(text.substring(i, i+2));
				if(smileyCount.containsKey(textSmileys.get(text.substring(i, i+2))))
				{	
					int count  =  smileyCount.get(textSmileys.get(text.substring(i, i+2)));
					smileyCount.put(textSmileys.get(text.substring(i, i+2)), count+1);
				}
				else
				{
					smileyCount.put(textSmileys.get(text.substring(i, i+2)), 1);
				}
			}
		}
		return smileyCount;
	}
}
