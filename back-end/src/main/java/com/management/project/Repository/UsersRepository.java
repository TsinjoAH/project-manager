package com.management.project.repository;

import com.management.project.model.Users;
import custom.springutils.LoginRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>, LoginRepo<Users> {
}
