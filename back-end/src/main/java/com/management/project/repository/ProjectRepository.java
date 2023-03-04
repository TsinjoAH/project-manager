package com.management.project.repository;

import com.management.project.model.Project;
import com.management.project.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
