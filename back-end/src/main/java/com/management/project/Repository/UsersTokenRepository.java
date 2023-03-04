package com.management.project.repository;

import com.management.project.model.token.UsersToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTokenRepository extends JpaRepository<UsersToken, String> {
}
