package com.management.project.Services;

import com.management.project.Model.Users;
import com.management.project.Repository.UsersRepository;
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
