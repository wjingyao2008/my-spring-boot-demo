package yang.yang.springbootdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by yanyan on 2017/07/17.
 */
@Entity
@Table(name = "task")
public class TaskRecord {

    public TaskRecord(Integer id, String createBy, String description) {
        this.id = id;
        this.createBy = createBy;
        this.description = description;
    }

    private @Id Integer id;

    private String createBy, description;

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private TaskRecord() {
    }

    public TaskRecord(String createBy, String description) {
        this.createBy = createBy;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }
}
