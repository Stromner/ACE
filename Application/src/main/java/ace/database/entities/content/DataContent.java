package ace.database.entities.content;

import ace.database.entities.Variable;

import javax.persistence.*;

/**
 * Abstract class to not generate separate table, stores data in db by the format specified by the generic
 * @param <E> data format
 */
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class DataContent<E> {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(nullable = false)
    private Variable variable;

    /**
     * Constructor needed by H2
     */
    protected DataContent() {

    }

    /**
     * General constructor used by program
     * @param variable name
     */
    public DataContent(Variable variable) {
        this.variable = variable;
    }

    /**
     * @return {@link DataContent#id}
     */
    public Long getId() {
        return id;
    }

    /**
     * @return {@link DataContent#variable}
     */
    public Variable getVariable() {
        return variable;
    }

    /**
     * @param variable set {@link DataContent#variable}
     */
    public void setVariable(Variable variable) {
        this.variable = variable;
    }

    /**
     * @return the stored value
     */
    public abstract E getDataContent();

    /**
     * @param dataContent new value to db
     */
    public abstract void setDataContent(E dataContent);

    @Override
    public String toString() {
        return "DataContent{" +
                "id=" + id +
                ", variable=" + variable +
                '}';
    }
}
