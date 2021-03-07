package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Database entry for storing UTF16 strings
 */
@Entity(name = "UTF16_CONTENT")
public class UTF16Content extends DataContent<String> {
    @Column(name = "utf16DataContent", nullable = false, length = 255)
    private String dataContent;

    /**
     * Constructor needed by H2
     */
    protected UTF16Content() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public UTF16Content(Variable variable, String dataContent) {
        super(variable);
        this.dataContent = dataContent;
    }

    @Override
    public String getDataContent() {
        return dataContent;
    }

    @Override
    public void setDataContent(String dataContent) {
        this.dataContent = dataContent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "UTF16Content{" +
                "dataContent='" + dataContent + '\'' +
                '}';
    }
}
