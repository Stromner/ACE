package ace.data.file.handling.writer;

/**
 * Interface for saving data to file
 */
public interface IFileWriter {
    /**
     * Saves file back to disk
     * @param filePath absolute path to the file
     */
    void saveFile(String filePath);
}
