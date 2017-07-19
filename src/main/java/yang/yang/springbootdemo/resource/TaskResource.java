package yang.yang.springbootdemo.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import yang.yang.springbootdemo.entity.TaskRecord;
import yang.yang.springbootdemo.repository.TaskRepository;

import java.util.List;

/**
 * Created by yanyan on 2017/07/19.
 */
@Profile("task")
@RestController
@RequestMapping("task")
public class TaskResource {

    private TaskRepository taskRepository;

    @Autowired
    public TaskResource(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @RequestMapping
    public List<TaskRecord> getTaksFromCreateBy(@RequestParam("usr")String userName) {
        return taskRepository.findByCreateBy(userName);
    }

}
