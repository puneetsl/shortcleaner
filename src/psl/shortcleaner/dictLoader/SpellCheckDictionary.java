package psl.shortcleaner.dictLoader;

import java.io.IOException;
import java.util.List;
import java.util.zip.ZipFile;

import org.dts.spell.SpellChecker;
import org.dts.spell.dictionary.OpenOfficeSpellDictionary;
import org.dts.spell.dictionary.SpellDictionary;
import org.dts.spell.finder.Word;

import psl.shortcleaner.utils.QGram;

public class SpellCheckDictionary implements Dictionary{

	private static SpellDictionary dict = null;
	private void loadSpellCheckDictionary()
	{
		try {
			dict = new OpenOfficeSpellDictionary(new ZipFile("./Dictionaries/en_us.oxt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public String getDictionaryValue(String text) {
		loadSpellCheckDictionary();
		SpellChecker checker = new SpellChecker(dict) ; 
		checker.setCaseSensitive(false) ;
		Word badWord = checker.checkSpell(text) ;
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
					if(max<tempCmp)
					{
						max = tempCmp;
						minIndex = i;
					}
					i++;
				}
				return suggestions.get(minIndex);
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
