package com.management.project.Model.Token;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class UsersToken extends Token{
    @Column
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
