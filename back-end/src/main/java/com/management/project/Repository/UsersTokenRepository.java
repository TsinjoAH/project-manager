package com.management.project.Repository;

import com.management.project.Model.token.UsersToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersTokenRepository extends JpaRepository<UsersToken, String> {
}
