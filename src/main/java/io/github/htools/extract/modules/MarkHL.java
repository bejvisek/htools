package io.github.htools.extract.modules;

import io.github.htools.search.ByteRegex;
import io.github.htools.search.ByteSearchPosition;
import io.github.htools.extract.Content;
import io.github.htools.extract.Extractor;
import io.github.htools.search.ByteSearch;
import io.github.htools.search.ByteSearchSection;
import io.github.htools.lib.Log;

/**
 * Marks &lt;hl&gt; sections, which are sometimes used in news wires to tag the
 * title.
 * <p>
 * @author jbpvuurens
 */
public class MarkHL extends SectionMarker {

   public static Log log = new Log(MarkHL.class);
   public ByteSearch endmarker = ByteSearch.create("</hl>");

   public MarkHL(Extractor extractor, String inputsection, String outputsection) {
      super(extractor, inputsection, outputsection);
   }

   @Override
   public ByteRegex getStartMarker() {
      return new ByteRegex("<hl>");
   }

   @Override
   public ByteSearchSection process(Content content, ByteSearchSection section) {
      ByteSearchPosition end = endmarker.findPos(section);
      if (end.found() && end.start > section.innerstart) {
          return content.addSectionPos(outputsection, content.content, section.start, section.innerstart, end.start, end.end);
      }
      return null;
   }
}
