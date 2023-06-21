package com.joel.todoapi.service;

import com.joel.todoapi.exceptions.ToDoExceptions;
import com.joel.todoapi.mapper.TaskInDTOToTask;
import com.joel.todoapi.persistence.entity.Task;
import com.joel.todoapi.persistence.entity.TaskStatus;
import com.joel.todoapi.persistence.repository.TaskRepository;
import com.joel.todoapi.service.dto.TaskInDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<Task> findAllByTaskStatus(TaskStatus status){
        return this.taskRepository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.markTaskFinished(id);
    }

    public void deleteById(Long id){
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        if(optionalTask.isEmpty()){
            throw new ToDoExceptions("Task not found", HttpStatus.NOT_FOUND);
        }
        this.taskRepository.deleteById(id);
    }

}