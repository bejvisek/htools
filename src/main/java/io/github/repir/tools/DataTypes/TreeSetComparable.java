package io.github.repir.tools.DataTypes;

import java.util.Collection;
import io.github.repir.tools.Lib.Log;
import java.util.TreeSet;
import io.github.repir.tools.DataTypes.TreeMapComparable.TYPE;
import io.github.repir.tools.DataTypes.TreeMapComparable.defaultComparable;

/**
 * A TreeSet containing non-unique integers that are sorted descending
 * <p/>
 * @author jeroen
 */
public class TreeSetComparable<K extends Comparable> extends TreeSet<K> {

   public static Log log = new Log(TreeSetComparable.class);
   
   public TreeSetComparable( TYPE t ) {
      super(new defaultComparable( t ));
   }
   
   public TreeSetComparable( TYPE t, Collection<K> coll ) {
      super(new defaultComparable( t ));
      this.addAll(coll);
   }
}