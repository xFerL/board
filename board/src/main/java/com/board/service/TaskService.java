package com.board.service;

import com.board.model.Task;
import com.board.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public Task createTask(Task task) {
        return repository.save(task);
    }

    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    public Task updateTask(Long id, Task updatedTask) {
        return repository.findById(id).map(task -> {
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setStatus(updatedTask.getStatus());
            task.setPriority(updatedTask.getPriority());
            task.setAssignee(updatedTask.getAssignee());
            return repository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

    public List<Task> getTasksByStatus(String status) {
        return repository.findByStatus(status);
    }

    public List<Task> getTasksByPriority(String priority) {
        return repository.findByPriority(priority);
    }

    public List<Task> getTasksByAssignee(String assignee) {
        return repository.findByAssignee(assignee);
    }

    public List<Task> getTasksByStatusAndPriority(String status, String priority) {
        return repository.findByStatusAndPriority(status, priority);
    }

    public List<Task> getTasksByStatusAndAssignee(String status, String assignee) {
        return repository.findByStatusAndAssignee(status, assignee);
    }
}
