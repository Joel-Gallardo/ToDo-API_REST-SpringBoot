package com.joel.todoapi.service;

import com.joel.todoapi.mapper.TaskInDTOToTask;
import com.joel.todoapi.persistence.entity.Task;
import com.joel.todoapi.persistence.repository.TaskRepository;
import com.joel.todoapi.service.dto.TaskInDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private final TaskRepository taskRepository;
    private final TaskInDTOToTask mapperTaskInDTOToTask;

    public TaskService(TaskRepository taskRepository, TaskInDTOToTask mapperTaskInDTOToTask) {
        this.taskRepository = taskRepository;
        this.mapperTaskInDTOToTask = mapperTaskInDTOToTask;
    }

    public Task createTask(TaskInDTO taskInDTO){
        Task task = mapperTaskInDTOToTask.map(taskInDTO);
        return this.taskRepository.save(task);
    }

    public List<Task> getAllTasks(){
        return this.taskRepository.findAll();
    }

}