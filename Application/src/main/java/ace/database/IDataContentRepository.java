package ace.database;

import ace.database.entities.content.DataContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Interface for H2 to create appropriate find methods under the hood
 */
public interface IDataContentRepository extends JpaRepository<DataContent<?>, Long> {
    /**
     * Finds first entity that matches variableName and returns its stored type
     * @param variableName {@link ace.database.entities.Variable} to find
     * @param <T> {@link DataContent} to be returned
     * @return the specific {@link DataContent}
     */
    <T extends DataContent<?>> T findByVariableName(String variableName);

    /**
     * Finds all entries that matches variableName and returns their stored type, type is expected to be same for all entries
     * @param variableName {@link ace.database.entities.Variable} to find
     * @param <T> {@link DataContent} to be returned
     * @return the specific {@link DataContent}
     */
    <T extends DataContent<?>> List<T> findAllByVariableName(String variableName);
}
