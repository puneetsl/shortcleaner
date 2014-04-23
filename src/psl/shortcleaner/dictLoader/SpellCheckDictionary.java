package psl.shortcleaner.dictLoader;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;

import org.dts.spell.SpellChecker;
import org.dts.spell.dictionary.OpenOfficeSpellDictionary;
import org.dts.spell.dictionary.SpellDictionary;
import org.dts.spell.finder.Word;

import psl.shortcleaner.utils.PropertiesInormation;
import psl.shortcleaner.utils.QGram;

public class SpellCheckDictionary implements Dictionary{

	private static SpellDictionary dict = null;
	private static SpellChecker checker;
	private void loadSpellCheckDictionary()
	{
		try {
			
			dict = new OpenOfficeSpellDictionary(new ZipFile(PropertiesInormation.getProperties().getProperty(this.getClass().getSimpleName())));
			checker = new SpellChecker(dict) ; 
			checker.setCaseSensitive(false) ;
			for(int i=0;i<1000000000;i++){}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getDictionaryValue(String text) {
		loadSpellCheckDictionary();
		Word badWord;
		try{
			badWord = checker.checkSpell(text.toLowerCase()) ;
			for(int i=0;i<100000000;i++){}
		}
		catch(Exception e)
		{
			return text;
		}
		
		if(badWord !=null)
		{
			double max=0;
			int minIndex=0;
			List<String> suggestions = dict.getSuggestions(badWord.toString(), 5);
			if(suggestions!=null)
			{
				int i=0;
				for (String sug : suggestions) {
					double tempCmp = QGram.compare(text, sug);
					//double brewCmp = TextBrew.compareAndGiveBestScore(text, sug);
					//tempCmp =tempCmp*0.8+brewCmp*0.2;//giving weights (8:2)
					
					if(max<tempCmp)
					{
						max = tempCmp;
						minIndex = i;
					}
					i++;
				}
				if(suggestions.size()>0)
					return suggestions.get(minIndex);
				else
					return text;
			}
			else
			{
				return text;
			}
		}
		else
		{
			return text;
		}
	}
}
