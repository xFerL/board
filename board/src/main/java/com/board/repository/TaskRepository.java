package com.board.repository;

import com.board.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    List<Task> findByStatus(String status);
    List<Task> findByPriority(String priority);
    List<Task> findByAssignee(String assignee);
    List<Task> findByStatusAndPriority(String status, String priority);
    List<Task> findByStatusAndAssignee(String status, String assignee);
}
