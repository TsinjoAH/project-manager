package com.management.project.Model.task;

import com.management.project.Model.Project;
import com.management.project.Model.Users;
import custom.springutils.exception.CustomException;
import custom.springutils.model.HasFK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


import java.sql.Timestamp;

@Entity
@Table(name = "Task")
public class Task extends HasFK<Project> {
    @ManyToOne
    Project project;
    @ManyToOne
    Users user;
    @Column
    String description;
    @Column
    Timestamp start_date;
    @Column
    Timestamp end_date;
    @Column
    int status;
    @Column
    int task_order;
    @ManyToOne
    private Task supere;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Task getSupere() {
        return supere;
    }

    public void setSupere(Task supere) {
        this.supere = supere;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTask_order() {
        return task_order;
    }

    public void setTask_order(int task_order) {
        this.task_order = task_order;
    }

    @Override
    public void setFK(Project project) throws CustomException {
        if (project != null) {
            this.project = project;
        } else {
            throw new CustomException("Project doesn't exist");
        }
    }
}
