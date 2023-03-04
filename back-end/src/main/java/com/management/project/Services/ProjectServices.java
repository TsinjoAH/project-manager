package com.management.project.Services;

import com.management.project.model.Project;
import com.management.project.model.Users;
import com.management.project.repository.ProjectRepository;
import com.management.project.repository.UsersRepository;
import custom.springutils.exception.CustomException;
import custom.springutils.service.CrudServiceWithFK;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProjectServices extends CrudServiceWithFK<Project, Users, ProjectRepository> {
    private final UsersRepository userRepo;
    public ProjectServices(ProjectRepository repo, UsersRepository userRepo) {
        super(repo);
        this.userRepo = userRepo;
    }

    @Override
    public List<Project> findForFK(Users users) {
        return null;
    }

    @Override
    public List<Project> findForFK(Users users, int i) {
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
    public Project create(@Valid Project project) throws CustomException {
        Project  pro= super.create(project);
        return pro;
    }
}
