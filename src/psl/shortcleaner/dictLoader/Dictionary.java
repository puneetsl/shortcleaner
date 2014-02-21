package psl.shortcleaner.dictLoader;

public interface Dictionary {
	/**   
     * Method to get string to find in dictionary
     * @author puneet
     * @param string to find the value in dictionary
     * @return  Dictionary value as <code>String</code>
     */
	public String getDictionaryValue(String text);
}
