package com.management.project.services;

import com.management.project.model.Users;
import com.management.project.repository.UsersRepository;
import custom.springutils.service.CrudService;
import org.springframework.stereotype.Service;

@Service
public class UsersCrudServices extends CrudService<Users, UsersRepository> {
    public UsersCrudServices(UsersRepository repo) {
        super(repo);
    }

    @Override
    public int getPageSize() {
        return 0;
    }
}
