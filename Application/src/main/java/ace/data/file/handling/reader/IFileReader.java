package ace.data.file.handling.reader;

/**
 * Interface for loading data into the application
 *
 * @param <V> Raw representation of the data
 */
public interface IFileReader<V> {
    /**
     * Loads save file into memory
     * @param filePath absolute path to file
     * @return read data
     */
    V loadFile(String filePath);

    /**
     * @return latest data read in by {@link IFileReader#loadFile(String)}
     */
    V getRawData();
}
