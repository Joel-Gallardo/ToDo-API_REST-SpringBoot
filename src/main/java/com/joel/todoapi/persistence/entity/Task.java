package com.joel.todoapi.persistence.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createDate;

    // eta = Estimated Time
    private LocalDateTime estimatedTime;
    private boolean finished;
    private TaskStatus taskStatus;

}
