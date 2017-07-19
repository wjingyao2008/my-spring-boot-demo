package yang.yang.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yanyan on 2017/07/17.
 */
@Entity
@Table(name = "employee")
public class Employee {

    public Employee(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    private @Id Integer id;

    private String name, description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private Employee() {
    }

    public Employee(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
}