package yang.yang.companydemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yang.yang.companydemo.entity.TaskRecord;

import java.util.List;

/**
 * Created by yanyan on 2017/07/17.
 */
@Repository
public interface TaskRepository extends CrudRepository<TaskRecord, Long> {

    List<TaskRecord> findByCreateBy(String name);
}