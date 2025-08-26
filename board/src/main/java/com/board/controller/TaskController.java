package com.board.controller;

import com.board.model.Task;
import com.board.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return service.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return service.getAllTasks();
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }

    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return service.getTasksByStatus(status);
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(@PathVariable String priority) {
        return service.getTasksByPriority(priority);
    }

    @GetMapping("/assignee/{assignee}")
    public List<Task> getTasksByAssignee(@PathVariable String assignee) {
        return service.getTasksByAssignee(assignee);
    }

    @GetMapping("/status/{status}/priority/{priority}")
    public List<Task> getTasksByStatusAndPriority(@PathVariable String status, @PathVariable String priority) {
        return service.getTasksByStatusAndPriority(status, priority);
    }

    @GetMapping("/status/{status}/assignee/{assignee}")
    public List<Task> getTasksByStatusAndAssignee(@PathVariable String status, @PathVariable String assignee) {
        return service.getTasksByStatusAndAssignee(status, assignee);
    }
}
