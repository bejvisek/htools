package io.github.repir.tools.collection;

import io.github.repir.tools.collection.ArrayMap;
import io.github.repir.tools.type.Tuple2;
import io.github.repir.tools.lib.Log;

/**
 * A TreeSet containing non-unique integers that are sorted descending
 * <p/>
 * @author jeroen
 */
public class ArrayMap3<K, V1, V2> extends ArrayMap<K, Tuple2<V1, V2>> {

   public static Log log = new Log(ArrayMap3.class);
   
   public ArrayMap3( ) {
      super();
   }
   
   public void add(K k, V1 v1, V2 v2) {
       super.add( k, new Tuple2<V1, V2>(v1, v2));
   }
}