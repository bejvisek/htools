package io.github.repir.tools.Latex;
import io.github.repir.tools.Latex.Tabular.Cell;
import io.github.repir.tools.Latex.Tabular.Row;
import io.github.repir.tools.Lib.Log; 

/**
 *
 * @author Jeroen Vuurens
 */
public interface RowModifier {
   public void modify( Row c, StringBuilder sb );
   public void modify( Cell c );
}
