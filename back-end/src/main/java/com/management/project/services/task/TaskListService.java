package com.management.project.Services.task;

import com.management.project.Model.task.Task;
import com.management.project.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskListService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasksByProjectId(Long projectId) {
        return taskRepository.findByProjectId(projectId);
    }
}
