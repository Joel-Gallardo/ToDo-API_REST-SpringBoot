package com.joel.todoapi.mapper;

import com.joel.todoapi.persistence.entity.Task;
import com.joel.todoapi.persistence.entity.TaskStatus;
import com.joel.todoapi.service.dto.TaskInDTO;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDTOToTask implements IMapper <TaskInDTO, Task> {
    @Override
    public Task map(TaskInDTO in) {
        Task task = new Task();
        task.setTitle(in.getTitle());
        task.setDescription(in.getDescription());
        task.setCreateDate(LocalDateTime.now());
        task.setEstimatedTime(in.getEstimatedTime());
        task.setFinished(false);
        task.setTaskStatus(TaskStatus.ON_TIME);
        return task;
    }
}
