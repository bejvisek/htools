package io.github.htools.hadoop.io.buffered;

import io.github.htools.lib.Log;

/**
 *
 * @author jeroen
 */
public class ComparatorInt extends ComparatorSub {

    public static final Log log = new Log(ComparatorInt.class);

    @Override
    public int compare(Comparator r) {
        int i = 0;
        for (; i < 4 && r.byte2[r.start2] != r.byte1[r.start1]; i++, r.start1++, r.start2++);
        if (i == 4)
            return 0;
        if (i == 0) {
            return r.byte1[r.start1] - r.byte2[r.start2];
        } 
        int a = (r.byte1[r.start1] & 0xff);
        int b = (r.byte2[r.start2] & 0xff);
        return a - b;
    }
}
