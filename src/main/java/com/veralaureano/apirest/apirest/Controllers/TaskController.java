package com.veralaureano.apirest.apirest.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.veralaureano.apirest.apirest.Entities.Task;
import com.veralaureano.apirest.apirest.Repositories.TaskRepository;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task geTask(@PathVariable Long id) {
        return taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found task with ID: " + id));
    }

    @PostMapping
    public Task postTask(@RequestBody Task task) {
        return taskRepository.save(task);
    }

    @PutMapping("/{id}")
    public Task putTask(@PathVariable Long id, @RequestBody Task newTask) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found task with ID: " + id));
        
        task.setName(newTask.getName());
        task.setDescription(newTask.getDescription());
        task.setIsComplete(newTask.getIsComplete());
    
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public Task deleteTask(@PathVariable Long id) {
        Task task = taskRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Not found task with ID: " + id));

        taskRepository.delete(task);

        return task;
    }
}
