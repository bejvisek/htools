package io.github.repir.tools.Content;

import io.github.repir.tools.Lib.Log;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.InputStream;

public class BytesIn implements DataIn {

   public static Log log = new Log(BytesIn.class);
   BufferReaderWriter buffer;
   public byte[] content;

   public BytesIn() {
   }

   public final void setBuffer(BufferReaderWriter buffer) {
      this.buffer = buffer;
   }

   public void mustMoveBack() {
      log.fatal("Cannot move BytesIn back");
   }

   public void close() {
      throw new UnsupportedOperationException("not possible to close fixed byte array");
   }

   public void fillBuffer(BufferReaderWriter buffer) {
      log.fatal("Trying to read past end of BytesIn record");
   }

   public long getLength() {
      return content.length;
   }

   public int readBytes(long offset, byte[] b, int pos, int length) {
      if (offset + length > content.length) {
         length = content.length - (int) offset;
      }
      if (length == 0) {
         length = -1;
      }
      for (int i = 0; i < length; i++) {
         b[pos + i] = content[(int) offset + i];
      }
      return length;
   }

   public void openRead() {
   }

   public InputStream getInputStream() {
      return new ByteArrayInputStream(content);
   }

   public void fillBufferForce(BufferReaderWriter buffer) throws EOFException {
      log.fatal("Trying to read past end of BytesIn record");
   }
}
