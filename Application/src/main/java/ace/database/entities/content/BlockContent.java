package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Arrays;

/**
 * Database entry for storing the begin_block end_block tags
 */
@Entity
public class BlockContent extends DataContent<byte[]> {
    @Column(name = "blockDataContent", nullable = false, length = 19)
    private byte[] dataContent;

    /**
     * Constructor needed by H2
     */
    protected BlockContent() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public BlockContent(Variable variable, byte[] dataContent) {
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
                "BlockContent{" +
                "dataContent=" + Arrays.toString(dataContent) +
                '}';
    }
}