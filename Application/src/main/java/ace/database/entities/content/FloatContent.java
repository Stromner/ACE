package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Database entry for storing floats
 */
@Entity
public class FloatContent extends DataContent<Float> {
    @Column(name = "floatDataContent", nullable = false, length = 16)
    private Float dataContent;

    /**
     * Constructor needed by H2
     */
    protected FloatContent() {

    }

    /**
     * General constructor used by program
     * @param variable name
     * @param dataContent byte content
     */
    public FloatContent(Variable variable, Float dataContent) {
        super(variable);
        this.dataContent = dataContent;
    }

    @Override
    public Float getDataContent() {
        return dataContent;
    }

    @Override
    public void setDataContent(Float dataContent) {
        this.dataContent = dataContent;
    }

    @Override
    public String toString() {
        return super.toString() +
                "FloatContent{" +
                "dataContent=" + dataContent +
                '}';
    }
}