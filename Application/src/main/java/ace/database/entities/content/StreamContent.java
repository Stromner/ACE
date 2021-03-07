package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Arrays;

/**
 * Database entry for storing byte arrays of unspecified sizes
 */
@Entity
public class StreamContent extends DataContent<byte[]> {
    @Column(name = "streamDataContent", nullable = false, length = 255)
    private byte[] dataContent;

    /**
     * Constructor needed by H2
     */
    protected StreamContent() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public StreamContent(Variable variable, byte[] dataContent) {
        super(variable);
        this.dataContent = dataContent;
    }

    @Override
    public byte[] getDataContent() {
        return dataContent;
    }

    @Override
    public void setDataContent(byte[] dataContent) {
        this.dataContent = dataContent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "StreamContent{" +
                "dataContent=" + Arrays.toString(dataContent) +
                '}';
    }
}
