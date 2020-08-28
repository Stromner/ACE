package ace.database;

import ace.database.entities.content.DataContent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDataContentRepository extends JpaRepository<DataContent<?>, Long> {
    <T extends DataContent<?>> T findByVariableName(String variableName);

    <T extends DataContent<?>> List<T> findAllByVariableName(String variableName);
}
