package Archive;

import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.IndexWord;
import net.didion.jwnl.data.POS;
import net.didion.jwnl.data.Synset;
import net.didion.jwnl.data.Word;
import net.didion.jwnl.dictionary.Dictionary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class WordNet {

    ArrayList<String> words;

    public ArrayList<String> synonym(String lemma) {

        try {

            JWNL.initialize(new FileInputStream("src/Archive/.idea/properties.xml"));
            Dictionary dictionary = Dictionary.getInstance();

            POS pos = POS.VERB;

            IndexWord indexWord = dictionary.lookupIndexWord(pos, lemma);
            if (null != indexWord) {

                Synset[] senses = indexWord.getSenses();

                for (Synset synset : senses) {

                    words = new ArrayList<String>();
                    for (Word word : synset.getWords()) {
                        words.add(word.getLemma());
                    }
                }
                return words;
            } else {
                words = new ArrayList<String>();
                words.add(lemma);
                return words;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JWNLException e) {
            e.printStackTrace();
        }

        words = new ArrayList<String>();
        words.add(lemma);
        return words;
    }

}
