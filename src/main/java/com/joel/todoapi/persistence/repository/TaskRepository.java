package com.joel.todoapi.persistence.repository;

import com.joel.todoapi.persistence.entity.Task;
import com.joel.todoapi.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus taskStatus);

    //consulta nativa desde jpa para hacer un update al campo finished de false a true
    @Modifying
    @Query(value = "UPDATE task SET finished = true WHERE id = :id", nativeQuery = true)
    public void markTaskFinished(@Param("id") Long id);
}
