package com.management.project.Model;

import custom.springutils.exception.CustomException;
import custom.springutils.model.HasFK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
public class Project extends HasFK<Users> {
    @ManyToOne
    Users owner;
    @Column
    private String title;

    @Column(name = "start_date", nullable = false)
    private Timestamp start_date;

    @Column(name = "end_date", nullable = false)
    private Timestamp end_date;


    public Project() {
        this.start_date = Timestamp.valueOf(LocalDateTime.now());
        this.end_date = Timestamp.valueOf(LocalDateTime.now().plusHours(5));
    }

    public Users getOwner() {
        return owner;
    }

    public void setOwner(Users owner) {
        this.owner = owner;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public void setFK(Users user) throws CustomException {
        if (user != null) {
            this.owner = user;
        } else {
            throw new CustomException("User not found");
        }
    }

    @Override
    public String toString() {
        return "Project{" +
                "owner=" + owner +
                ", title='" + title + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
