package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Arrays;

/**
 * Database entry for storing ids which have a specific size
 */
@Entity
public class IdContent extends DataContent<byte[]> {
    @Column(name = "idDataContent", nullable = false, length = 16)
    private byte[] dataContent;

    /**
     * Constructor needed by H2
     */
    protected IdContent() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public IdContent(Variable variable, byte[] dataContent) {
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
                "IdContent{" +
                "dataContent=" + Arrays.toString(dataContent) +
                '}';
    }
}
