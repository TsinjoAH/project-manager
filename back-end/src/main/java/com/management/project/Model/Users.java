package com.management.project.Model;

import custom.springutils.LoginEntity;
import custom.springutils.model.HasName;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.apache.commons.codec.digest.DigestUtils;

@Entity
@Table(name = "users")
public class Users extends HasName implements LoginEntity {
    @Column
    String name;
    @Column
    String contact;
    @Column
    String email;
    @Column
    String password;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }


    @Override
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = DigestUtils.sha1Hex(password);
    }

}
