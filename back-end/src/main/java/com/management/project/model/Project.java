package com.management.project.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import custom.springutils.exception.CustomException;
import custom.springutils.model.HasFK;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import javax.validation.constraints.AssertTrue;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "project")
public class Project extends HasFK<Users> {
        @ManyToOne
        Users owner;
    @Column
    private String title;
    @Column(name="start_date")
    private Timestamp startDate = Timestamp.valueOf(LocalDateTime.now());
    @Column(name="end_date")
    private Timestamp endDate;

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

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
    @AssertTrue(message = "End date must be after start date")
    private boolean isEndDateValid() {
        return endDate == null || endDate.after(startDate);
    }
    @Override
    public void setFK(Users user) throws CustomException {
        if(user!=null){
            this.owner=user;
        }else {
            throw new CustomException("User not found");
        }
    }
}
