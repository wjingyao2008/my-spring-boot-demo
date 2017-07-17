package yang.yang.springbootdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yang.yang.springbootdemo.entity.Employee;
import yang.yang.springbootdemo.repository.EmployeeRepository;
import yang.yang.springbootdemo.repository.ManagerRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanyan on 2017/07/17.
 */
@Service
public class CompanyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ManagerRepository managerRepository;

    public List<Employee> getAllEmployees(String name) {

        LOGGER.info("get employee by {}", name);
        return employeeRepository.findByName(name);
    }

    public List<Employee> getAllEmployees() {

        LOGGER.info("get all employees ");
        List<Employee> employeeList = new ArrayList<>();
        Iterable<Employee> all = employeeRepository.findAll();
        for (Employee employee : all) {
            LOGGER.info("get {}", employee.getName());
            employeeList.add(employee);
        }
        return employeeList;
    }

    public String addBulkEmployee() {

        return "done";
    }
}
