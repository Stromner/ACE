package ace.database.entities;

import javax.persistence.*;

/**
 * Entry for each variable that exists
 */
@Entity
public class Variable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private VariableType variableType;
    @Column(nullable = false, length = 255)
    private String name;

    /**
     * Constructor needed by H2
     */
    protected Variable() {
    }

    /**
     * General constructor used by program
     * @param name name of the variable
     * @param variableType type of data for the variable
     */
    public Variable(String name, VariableType variableType) {
        this.name = name;
        this.variableType = variableType;
    }

    /**
     * Needed by H2
     * @return {@link Variable#id}
     */
    public Long getId() {
        return id;
    }

    /**
     * @return {@link Variable#variableType}
     */
    public VariableType getVariableType() {
        return variableType;
    }

    /**
     * @param variableType sets {@link Variable#variableType}
     */
    public void setVariableType(VariableType variableType) {
        this.variableType = variableType;
    }

    /**
     * @return {@link Variable#name}
     */
    public String getName() {
        return name;
    }

    /**
     * @param name sets {@link Variable#name}
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Variable{" +
                "id=" + id +
                ", variableType=" + variableType +
                ", name='" + name + '\'' +
                '}';
    }
}
