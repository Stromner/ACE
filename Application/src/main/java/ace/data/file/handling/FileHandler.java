package ace.data.file.handling;

import ace.data.file.handling.reader.IFileReader;
import ace.data.file.handling.writer.IFileWriter;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 *
 * @param <V> Format for the raw data
 */
@Component
public class FileHandler<V> implements IFileHandler<V> {
    @Resource(name = "databaseFileReader")
    IFileReader<V> fileReader;
    @Resource(name = "databaseFileWriter")
    IFileWriter fileWriter;

    @Override
    public V loadFile(String filePath) {
        return fileReader.loadFile(filePath);
    }

    @Override
    public V getRawData() {
        return fileReader.getRawData();
    }

    @Override
    public void saveFile(String filePath) {
        fileWriter.saveFile(filePath);
    }
}
