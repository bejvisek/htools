/*
 * Copyright 2013 jeroen.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package UnitTest;

import java.io.EOFException;
import io.github.repir.tools.Content.BufferReaderWriter;
import io.github.repir.tools.Content.Datafile;
import io.github.repir.tools.Content.RecordBinary;
import io.github.repir.tools.Content.RecordSort;
import io.github.repir.tools.Content.RecordSortCollision;
import io.github.repir.tools.Content.RecordSortCollisionRecord;
import io.github.repir.tools.Content.RecordSortRecord;
import io.github.repir.tools.Lib.ByteTools;
import io.github.repir.tools.Lib.RandomTools;

/**
 *
 * @author jeroen
 */
public class RecordSortCollisionTest extends RecordSortCollision {
   String0Field name = this.addString0("name");
   IntField count = this.addInt("count");
   
   public static void main(String[] args) {
      RecordSortCollisionTest table = new RecordSortCollisionTest( new Datafile("C:/users/Jeroen/Desktop/test"));
      String names[] = new String[10];
      table.setTableSize(names.length);
      log.info("capacity %d", table.getBucketCapacity());
      table.openWrite();
      for (int i = 0; i < names.length; i++) {
         names[i] = RandomTools.uuid();
         Record r = (Record)table.createRecord();
         r.name = names[i];
         r.count = i + 1;
         r.write();
      }
      table.closeWrite();
      table.openRead();
      for (String n : names) {
         Record r = (Record)table.createRecord();
         r.name = n;
         Record find = (Record)table.find(r);
         log.printf("%s %d", n, find.count);
      }
      table.closeRead();
   }
   
   public RecordSortCollisionTest(Datafile df) {
      super(df);
   }

   @Override
   public RecordBinary clone() {
         RecordSortCollisionTest f = new RecordSortCollisionTest(new Datafile(datafile));
         f.setTableSize(this.getTableSize());
         return f;
   }

   @Override
   public int secondaryCompare(RecordSort o1, RecordSort o2) {
      return (((RecordSortCollisionTest)o1).count.value > ((RecordSortCollisionTest)o2).count.value)?1:-1;
   }

   @Override
   public int secondaryCompare(RecordSortRecord o1, RecordSortRecord o2) {
      return (((Record)o1).count > ((Record)o2).count)?1:-1;
   }

   @Override
   public RecordSortCollisionRecord find(BufferReaderWriter table, RecordSortCollisionRecord r) {
         Record rr = (Record) r;
         byte needle[] = rr.name.getBytes();
         int match;
         int offset = table.bufferpos;
         log.info("find() %s offset %d end %d", rr.name, offset, table.end);
         while (table.bufferpos < table.end) {
            try {
               for (match = 0; match < needle.length && table.buffer[table.bufferpos + match] == needle[match]; match++);
               log.info("match %d", match);
               if (match == needle.length && table.buffer[table.bufferpos + match] == 0) {
                  table.skipString0();
                  rr.count = table.readInt();
                  return rr;
               }
               int bucketindex = ByteTools.string0HashCode(table.buffer, table.bufferpos, table.end) & (this.getBucketCapacity() - 1);
               if (bucketindex > rr.getBucketIndex()) {
                  break;
               }
               String s = table.readString0();
               log.info("%s %s", rr.name, s);
               table.skip(4);
            } catch (EOFException ex) {
               log.exception(ex, "find( %s, %s )", table, r);
            }
         }
         return null;
   }

   @Override
   public RecordSortRecord createRecord() {
      Record r = new Record(this);
      r.name = name.value;
      r.count = count.value;
      return r;
   }

   public class Record extends RecordSortCollisionRecord {

         public String name;
         public int count;

         public Record( RecordSortCollisionTest file ) {
            super( file );
         }

         public int hashCode() {
            return name.hashCode();
         }
         
         @Override
         protected void writeRecordData() {
            ((RecordSortCollisionTest) file).name.write(name);
            ((RecordSortCollisionTest) file).count.write(count);
         }

         @Override
         protected void writeTempRecordData() {
            ((RecordSortCollisionTest) file).name.write(name);
            ((RecordSortCollisionTest) file).count.write(count);
         }

         @Override
         public boolean equals(RecordSortCollisionRecord r) {
            log.info("equals %s %s", name, ((Record) r).name);
            return name.equals(((Record) r).name);
         }
      }
}