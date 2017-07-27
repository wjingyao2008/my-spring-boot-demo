package yang.yang.companydemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import yang.yang.companydemo.entity.Employee;
import yang.yang.companydemo.service.CompanyService;

import java.util.List;

/**
 * Created by yanyan on 2017/07/17.
 */
//RestController is combine of @Controller and @ResponseBody
@RestController
@RequestMapping("company")
public class CompanyResource {

    private final CompanyService service;

    @Autowired
    public CompanyResource(CompanyService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployeesByName(@RequestParam("name") String name) {
        return service.getAllEmployees(name);
    }

    @RequestMapping(value = "all", method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @RequestMapping(value = "buck_insert", method = RequestMethod.PUT)
    @ResponseBody
    public String addBulkEmployee() {
        return service.addBulkEmployee();
    }
}
