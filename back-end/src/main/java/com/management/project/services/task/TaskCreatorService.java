package com.management.project.Services.task;

import com.management.project.Model.Project;
import com.management.project.Model.task.Task;
import com.management.project.Repository.TaskRepository;
import custom.springutils.exception.CustomException;
import custom.springutils.service.CrudServiceWithFK;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class TaskCreatorService extends CrudServiceWithFK<Task, Project, TaskRepository> {

    public TaskCreatorService(TaskRepository repo) {
        super(repo);
    }

    @Override
    public List<Task> findForFK(Project project) {
        return null;
    }

    @Override
    public List<Task> findForFK(Project project, int i) {
        return null;
    }

    @Override
    public int getPageCount(Project project) {
        return 0;
    }

    @Override
    public int getPageSize(Project project) {
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

    public void createNewTask(Project project, String description, int status, Timestamp startDate, Timestamp endDate, int taskOrder) throws CustomException {
        Task newTask = new Task();
        newTask.setProject(project);
        newTask.setDescription(description);
        newTask.setStart_date(startDate);
        newTask.setEnd_date(endDate);
        newTask.setTask_order(taskOrder);
        newTask.setStatus(status);
        this.create(newTask);
    }
}
