package psl.shortcleaner.cleaners;


public interface ShortCleaner {
    /**
     * setText would be used to set the dirty text which 
     * would get cleaned the classes which would implement 
     * this interface.<p>
     * As there would be multiple cleaners cleaning the text in
     * different roles one by one i.e. one cleaner's output
     * would be input of other cleaner. Thus, mostly
     * in the classes which implements ShortCleaner, this function
     * would be used internally by a controller class<p>
     * This function should also digest tagged text returned by previous
     * cleaners
     *
     * @param   dirty text as <code>string</code>
     * @return  void
     */
	public void setText(String shortText);
    
	/**   
     * Returns cleaned text in plain format
     * for e.g. "LOL this is awesome" would simple be returned as 
     * "Laughing out loud this is awesome"
     * 
     * @return  cleaned text as <code>String</code>
	 * @throws Exception 
     */
	public String getRawCleanText();
	
	/**   
     * Returns cleaned text in tagged format
     * for e.g. "LOL this is awesome" would simple be returned as 
     * "<smslingo baseText="LOL">Laughing out loud</smslingo> this is awesome"
     * 
     * @return  cleaned text as <code>String</code>
     */
	public String getTaggedText();
	/*
	 * TODO add JSON support for returning tagged 
	 */
}
