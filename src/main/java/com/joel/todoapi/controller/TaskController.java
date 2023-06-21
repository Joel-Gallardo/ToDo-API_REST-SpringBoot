package com.joel.todoapi.controller;

import com.joel.todoapi.persistence.entity.Task;
import com.joel.todoapi.service.TaskService;
import com.joel.todoapi.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return this.taskService.getAllTasks();
    }

}
