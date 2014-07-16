package io.github.repir.tools.Structure;

import java.io.DataOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author jbpvuurens
 */
public interface StructureWriter {

   public void setBufferSize(int i);

   public int getBufferSize();

   public void write(int i);

   public void write(boolean b);

   public void write2(int i);

   public void write3(int i);

   public void write(long i);

   public void write(double i);

   public void write(byte i);

   public void write(byte b[]);

   public void writeByteBlock(byte b[]);

   public void write(byte b[], int pos, int length);

   public void write(byte b[], byte eof[], byte escape);

   public void write(byte b[], byte eof[], byte endfield[], byte escape);

   public void writeUB(int i);

   public void writeC(int i);

   public void writeC(long i);

   public void writeC(double d);

   public void write(String s);

   public void write(StringBuilder s);

   public void write0(String s);

   public void write(int i[]);

   public void write(Collection<Integer> al);

   public void writeStr(Collection<String> al);

   public void writeC(int i[][]);

   public void writeSquared(int i[][]);

   public void writeSparse(int i[][]);

   public void writeC(int i[][][]);

   public void writeSparse(int i[][][]);

   public void writeSquared(int i[][][]);

   public void write(long l[]);

   public void writeC(long l[][]);

   public void writeSparse(long l[][]);

   public void write(double s[]);

   public void writeSparse(double[] array);

   public void write(String s[]);

   public void writeC(int s[]);

   public void writeIncr(int s[]);

   public void writeIncr(ArrayList<Integer> list);

   public void writeC(ArrayList<Integer> s);

   public void writeC(long s[]);

   public void writeSparse(long[] array);

   public void writeSparseLong(Map<Integer, Long> map);

   public void writeSparse(int[] array);

   public void writeSparseInt(Map<Integer, Integer> map);

   public void write(Map<String, String> map);

   public void writeBuffer(DataOutput out);

   public void writeBuffer(StructureWriter writer);

   public long getOffset();
}