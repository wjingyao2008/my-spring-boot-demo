package yang.yang.companydemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yang.yang.companydemo.entity.Employee;

import java.util.List;

/**
 * Created by yanyan on 2017/07/17.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    List<Employee> findByName(String name);
}