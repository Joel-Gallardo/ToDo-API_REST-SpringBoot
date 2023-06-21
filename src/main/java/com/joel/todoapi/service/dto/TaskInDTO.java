package com.joel.todoapi.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class TaskInDTO {
    private String title;
    private String description;

    // eta = Estimated Time
    private LocalDateTime estimatedTime;
}
