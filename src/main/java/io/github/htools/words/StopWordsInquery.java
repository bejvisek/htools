package io.github.htools.words;

import io.github.htools.lib.Log;
import java.util.HashSet;

public class StopWordsInquery {
   public static Log log = new Log( StopWordsInquery.class );
   
   public static String filterarray[] =
      ("a about above according across after afterwards again against albeit all almost "
    + "alone along already also although always among amongst am an and another any anybody "
    + "anyhow anyone anything anyway anywhere apart are around as at av "
    + "be became because become becomes becoming been before beforehand behind being "
    + "below beside besides between beyond both but by can cannot canst certain cf " 
    + "choose contrariwise cos could cu day do does doesnt doing dost double down "
    + "dual during each either else elsewhere enough et etc even ever every everybody "
    + "everyone everything everywhere except excepted excepting exception exclude "
    + "excluding exclusive far farther farthest few ff first for former formerly forth "
    + "forward from front further furthermore furthest get go had halves haedly has "
    + "hast hath have he hence henceforth her here hereabouts hereafter hereby herein "
    + "hereto hereupon hers herself him himself hindmost his hither how however howsoever " 
    + "i ie if in inasmuch inc include included including indeed indoors inside insomuch "
    + "instead into inward is it its itself just kind kg km last latter latterly less "
    + "lest let like little ltd many may maybe me meantime meanwhile might moreover most "
    + "mostly more mr mrs ms much must my myself namely need neither never nevertheless "
    + "next no nobody none nonetheless noone nope nor not nothing notwithstanding now "
    + "nowadays, nowhere of off often ok on once one only onto or other others otherwise "
    + "ought our ours ourselves out outside over own per perhaps plenty provide quite "
    + "rather really round said same sang save saw see seeing seem seemed seeming seems "
    + "seen seldom selves sent several shalt she should shown sideways since slept slew "
    + "slung slunk smote so some somebody somehow someone something sometime sometimes "
    + "somewhat somewhere spake spat spoke spoken sprang sprung staves still such "
    + "supposing than that the thee their them themselves then thence thenceforth "
    + "there thereabout thereabouts thereafter thereby therefore therein thereof "
    + "thereon thereto thereupon these they this those thou though thrice through "
    + "throughout thru thus thy thyself till to together too toward towards ugh unable "
    + "under underneath unless unlike until up upon upward us use used using very via "
    + "vs want was we week well were what whatever whatsoever when whence whenever whensoever "
    + "where whereabouts whereafter whereas whereat whereby wherefore wherefrom wherein "
    + "whereinto whereof whereon wheresoever whereto whereunto whereupon wherever "
    + "wherewith whether whew which whichever whichsoever while whilst whither who whoever "
    + "whole whom whomever whomsoever whose whosoever why will wilt with within without "
    + "worse worst would wow ye yet year yipee you your yours yourself yourselves").split(" ");

   public static HashSet<String> getUnstemmedFilterSet() {
      HashSet<String> set = new HashSet<String>();
      for (String s : filterarray) {
         set.add(s);
      }
      return set;
   }
}
