package EleventhHomeWorks;

import SixthHomeWorks.MapSecondVersion;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Iterator;

public class BufferedWriterOutputStramDecoratorIniFiles extends OutputStream {
    private BufferedWriter bufferedWriter;

    public BufferedWriterOutputStramDecoratorIniFiles(OutputStream outputStream) {
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
    }

    public void writeAll(MapSecondVersion<String,MapSecondVersion<Object,Object>> map) throws IOException {
        Iterator keyIterator = map.keySet().iterator();
        Iterator valIterator = map.values().iterator();

        while(keyIterator.hasNext()){
            MapSecondVersion values = (MapSecondVersion) valIterator.next();
            writeSection(values,keyIterator.next().toString());
        }
    }

    public void writeSection(MapSecondVersion<Object,Object> map,String sectionName) throws IOException {
        bufferedWriter.write(sectionName);
        bufferedWriter.newLine();

        Iterator keyIterator = map.keySet().iterator();
        Iterator valIterator = map.values().iterator();

        while(keyIterator.hasNext()) {
            String key = keyIterator.next().toString();
            String val = valIterator.next().toString();
            bufferedWriter.write(key + "=" + val);
            bufferedWriter.newLine();
        }
    }

    @Override
    public void write(int b) throws IOException {
        bufferedWriter.write(b);
    }
}
