package io.github.htools.extract.modules;

import io.github.htools.words.StopWordsContractions;
import io.github.htools.lib.Log;
import io.github.htools.extract.Extractor;
import io.github.htools.words.StopWordsLetter;
import io.github.htools.words.StopWordsSmart;
import io.github.htools.words.StopWordsUrl;

/**
 * Processes all tokens in the supplied EntityChannel though the snowball
 * (Porter 2) stemmer.
 */
public class RemoveStopwordsSmart extends RemoveFilteredWords {

   private static Log log = new Log(RemoveStopwordsSmart.class);

   public RemoveStopwordsSmart(Extractor extractor, String process) {
      super(extractor, process);
      this.addWords(StopWordsSmart.getUnstemmedFilterSet());
      this.addWords(StopWordsContractions.getUnstemmedBrokenFilterSet());
//      this.words.add("s");
//      this.words.add("t");
//      this.words.add("d");
//      this.words.add("i");
//      this.words.add("m");
   }
}