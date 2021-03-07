package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Database entry for storing UTF8 strings
 */
@Entity(name = "UTF8_CONTENT")
public class UTF8Content extends DataContent<String> {
    @Column(name = "utf8DataContent", nullable = false, length = 255)
    private String dataContent;

    /**
     * Constructor needed by H2
     */
    protected UTF8Content() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public UTF8Content(Variable variable, String dataContent) {
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
                "UTF8Content{" +
                "dataContent='" + dataContent + '\'' +
                '}';
    }
}
