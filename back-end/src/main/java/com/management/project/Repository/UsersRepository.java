package com.management.project.Repository;

import com.management.project.Model.Users;
import custom.springutils.LoginRepo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users, Long>, LoginRepo<Users> {
}
