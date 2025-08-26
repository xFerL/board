package com.board.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String status; // TO_DO, IN_PROGRESS, DONE
    private String priority; // LOW, MEDIUM, HIGH
    private String assignee; // usuário responsável
    private LocalDateTime createdAt; // data de criação

    public Task() {}

    public Task(String title, String description, String status, String priority, String assignee, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.status = status;
        this.priority = priority;
        this.assignee = assignee;
        this.createdAt = createdAt;
    }

    // Getters e Setters omitidos por brevidade
}
