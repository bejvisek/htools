package io.github.repir.tools.ByteRegex;

import io.github.repir.tools.Lib.Log;
import java.util.ArrayList;

public class Fragment {

   public Node start;
   public ArrayList<Node> end = new ArrayList<Node>();

   public void addEnd(Node n) {
      end.add(n);
   }

   public void addEnd(Fragment f) {
      for (Node n : f.end) {
         end.add(n);
      }
   }

   public void setEnds(Node n) {
      for (Node e : end) {
         for (int i = 0; i < e.next.length; i++) {
            if (e.next[i] == null) {
               e.next[i] = n;
               break;
            }
         }
      }
      end = new ArrayList<Node>();
   }
}
