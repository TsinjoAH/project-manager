package com.management.project.services.task;

import com.management.project.model.Users;
import com.management.project.model.task.Task;
import com.management.project.repository.TaskRepository;
import custom.springutils.exception.CustomException;
import custom.springutils.service.CrudServiceWithFK;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskAssignUserService extends CrudServiceWithFK<Task, Users, TaskRepository> {
    public TaskAssignUserService(TaskRepository repo) {
        super(repo);
    }

    @Override
    public List<Task> findForFK(Users users) {
        return null;
    }

    @Override
    public List<Task> findForFK(Users users, int i) {
        return null;
    }

    @Override
    public int getPageCount(Users users) {
        return 0;
    }

    @Override
    public int getPageSize(Users users) {
        return 0;
    }

    @Override
    public int getPageSize() {
        return 0;
    }

    @Transactional
    public Task create(Task task) throws CustomException {
        Task creator = super.create(task);
        return creator;
    }

    @Transactional
    public void assignUserToTask(Long taskId, Long userId) {
        Task task = this.findById(taskId);
        if (task != null) {
            Users user = new Users();
            user.setId(userId);
            task.setUser(user);
        }
        try {
            this.create(task);
        } catch (CustomException e) {
            throw new RuntimeException(e);
        }
    }
}
