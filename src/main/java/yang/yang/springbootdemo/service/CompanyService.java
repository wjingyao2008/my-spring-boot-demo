package yang.yang.springbootdemo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import yang.yang.springbootdemo.entity.Employee;
import yang.yang.springbootdemo.entity.TaskRecord;
import yang.yang.springbootdemo.repository.EmployeeRepository;
import yang.yang.springbootdemo.repository.TaskRepository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * Created by yanyan on 2017/07/17.
 */
@Service
public class CompanyService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyService.class);


    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final JdbcTemplate jdbcTemplate;
    private final TransactionTemplate transactionTemplate;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private TaskRepository taskRepository;

    public CompanyService(JdbcTemplate jdbcTemplate, PlatformTransactionManager transactionManager) {
        this.jdbcTemplate = jdbcTemplate;
        namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @Transactional
    public List<Employee> getAllEmployees(String name) {

        LOGGER.info("get employee by {}", name);
        return employeeRepository.findByName(name);
    }
    @Transactional
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
    @Transactional
    public String addBulkEmployee() {
        createNewEmployee("cb1");
        bulkAddTask("cb1");
//        raiseException();
        return "done";
    }



    @Transactional
    public void raiseException(){
        testTransactional();
    }

    private void testTransactional() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException("raiseException rollback for exception in bulk");
        }
        throw new RuntimeException("raiseException rollback for exception in bulk");
    }

    @Transactional
    public void bulkAddTask(String name) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            // the code in this method executes in a transactional context
            protected void doInTransactionWithoutResult(TransactionStatus status) {
//                operationInJdbcTemplate();
                operationInNamedJdbcTemplate();
            }

            private void operationInJdbcTemplate() {
                List<TaskRecord> allTasks = IntStream.range(0, 100).mapToObj(
                        i -> new TaskRecord(name, "task:" + i)).collect(
                        Collectors.toList());
                String sql = "INSERT INTO task (id,create_by,description) VALUES (?,?,?)";
                jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
                    int id = 5000;

                    @Override public void setValues(PreparedStatement ps, int i) throws SQLException {
                        TaskRecord taskRecord = allTasks.get(i);
                        ps.setInt(1, id++);
                        ps.setString(2, taskRecord.getCreateBy());
                        ps.setString(3, taskRecord.getDescription());
                    }

                    @Override public int getBatchSize() {
                        return allTasks.size();
                    }
                });
                LOGGER.info("inserting done");
            }

            private void operationInNamedJdbcTemplate() {
                List<TaskRecord> allTasks = IntStream.range(5000, 5600).mapToObj(
                        i -> new TaskRecord(i, name, "task:" + i)).collect(Collectors.toList());
                String sql = "INSERT INTO task (id,create_by,description) VALUES (:id,:createBy,:description)";

                List<SqlParameterSource> parameters = new ArrayList<>();
                for (TaskRecord task : allTasks) {
                    parameters.add(new BeanPropertySqlParameterSource(task));
                }
                namedParameterJdbcTemplate.batchUpdate(sql, parameters.toArray(new SqlParameterSource[0]));
                LOGGER.info("inserting done");
            }
        });

    }

    private void createNewEmployee(String name) {
        employeeRepository.save(new Employee( new Random().nextInt(), name, "a bulk raiseException"));
    }
}
