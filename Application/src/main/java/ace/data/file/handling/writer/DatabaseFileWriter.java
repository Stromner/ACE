package ace.data.file.handling.writer;

import ace.database.IDataContentRepository;
import ace.database.entities.VariableType;
import ace.database.entities.content.DataContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/**
 * Writes data back to the save file in the correct format
 */
@Component
public class DatabaseFileWriter implements IFileWriter {
    private static final Logger log = LoggerFactory.getLogger(DatabaseFileWriter.class);
    @Autowired
    private IDataContentRepository contentRepository;

    @Override
    public void saveFile(String filePath) {
        log.info("Started saving file...");
        File file = new File(filePath);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            for (DataContent<?> content : contentRepository.findAll(Sort.by(Sort.Direction.ASC, "id"))) {
                saveVariableName(fos, content);
                saveDataContent(fos, content);
            }
            fos.flush();
            fos.close();
            log.info("Finished saving file");
        } catch (IOException e) {
            log.error("Error while saving {}", e.getMessage());
            throw new RuntimeException(e.getCause());
        }
    }

    private void saveVariableName(FileOutputStream fos, DataContent<?> content) throws IOException {
        String varName = content.getVariable().getName();
        if (content.getVariable().getVariableType() != VariableType.BLOCK) {
            fos.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(varName.length()).array());
            fos.write(varName.getBytes());
        }
    }

    private void saveDataContent(FileOutputStream fos, DataContent<?> content) throws IOException {
        switch (content.getVariable().getVariableType()) {
            case INT -> {
                Integer i = (Integer) content.getDataContent();
                fos.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(i).array());
            }
            case FLOAT -> {
                Float f = (Float) content.getDataContent();
                fos.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(f).array());
            }
            case UTF8 -> saveString(fos, (String) content.getDataContent(), false);
            case UTF16 -> saveString(fos, (String) content.getDataContent(), true);
            case BLOCK, ID -> fos.write((byte[]) content.getDataContent());
            case STREAM -> {
                byte[] b = (byte[]) content.getDataContent();
                fos.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(b.length).array());
                fos.write(b);
            }
            default -> {
                log.error("Invalid variable type '{}'", content.getVariable().getVariableType());
                throw new RuntimeException("Invalid variable type");
            }
        }
    }

    private void saveString(FileOutputStream fos, String s, boolean isUTF16) throws IOException {
        int size = isUTF16 ? s.length() / 2 : s.length();

        fos.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(size).array());
        fos.write(s.getBytes());
    }
}
