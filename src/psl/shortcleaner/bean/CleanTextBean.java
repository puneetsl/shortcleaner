package psl.shortcleaner.bean;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * This bean class is used to extract basic features from a small text such as a tweet
 * The variables in the class would be inflated by extracting text based features
 */
public class CleanTextBean {
	private HashMap<String,Integer> emoticons;
	private String url;
	private ArrayList<String> urlWords; // will contain good words from the URL
	private int hashTags; //number of hash tags
	private String cleanText;
	private int linkCount;
	private int references;
	private int punctuationCount; // More punctuation could refer to better English
	private int dots;//Some people use lots of dots between text, can be used as a feature
	private int exclaimations;
	private int RTcount;
	
	public CleanTextBean() {
		emoticons = new HashMap<String,Integer>();
		url = "";
		urlWords = new ArrayList<String>();
		hashTags = 0;
		cleanText = "";
		linkCount =0;
		references =0;
		punctuationCount=0;
		dots=0;
		exclaimations=0;
		RTcount = 0;
	}

	public HashMap<String,Integer> getEmoticons() {
		return emoticons;
	}

	public void setEmoticons(HashMap<String,Integer> emoticons) {
		this.emoticons = emoticons;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<String> getUrlWords() {
		return urlWords;
	}

	public void addUrlWords(String urlWord) {
		urlWords.add(urlWord);
	}

	public int getHashTags() {
		return hashTags;
	}

	public void setHashTags(int hashTags) {
		this.hashTags = hashTags;
	}

	public String getCleanText() {
		return cleanText;
	}

	public void setCleanText(String cleanText) {
		this.cleanText = cleanText;
	}

	public int getLinkCount() {
		return linkCount;
	}

	public void setLinkCount(int linkCount) {
		this.linkCount = linkCount;
	}

	public int getReferences() {
		return references;
	}

	public void setReferences(int references) {
		this.references = references;
	}

	public int getPunctuationCount() {
		return punctuationCount;
	}

	public void setPunctuationCount(int punctuationCount) {
		this.punctuationCount = punctuationCount;
	}

	public int getDots() {
		return dots;
	}

	public void setDots(int dots) {
		this.dots = dots;
	}

	public int getExclaimations() {
		return exclaimations;
	}

	public void setExclaimations(int exclaimations) {
		this.exclaimations = exclaimations;
	}

	public int getRTcount() {
		return RTcount;
	}

	public void setRTcount(int rTcount) {
		RTcount = rTcount;
	}
	
	
	/*
	 * TODO: use this bean to fill features from short text
	 */
}
