package yang.yang.springbootdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import yang.yang.springbootdemo.entity.Employee;
import yang.yang.springbootdemo.entity.Manager;

import java.util.List;

/**
 * Created by yanyan on 2017/07/17.
 */
@Repository
public interface ManagerRepository extends CrudRepository<Manager, Long> {

    List<Employee> findByName(String name);
}