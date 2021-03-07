package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Database entry for storing ints
 */
@Entity
public class IntContent extends DataContent<Integer> {
    @Column(name = "intDataContent", nullable = false)
    private Integer dataContent;

    /**
     * Constructor needed by H2
     */
    protected IntContent() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public IntContent(Variable variable, int dataContent) {
        super(variable);
        this.dataContent = dataContent;
    }

    @Override
    public Integer getDataContent() {
        return dataContent;
    }

    @Override
    public void setDataContent(Integer dataContent) {
        this.dataContent = dataContent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "IntContent{" +
                "dataContent=" + dataContent +
                '}';
    }
}
