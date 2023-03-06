package com.management.project.services;

import com.management.project.model.token.UsersToken;
import com.management.project.model.Users;
import com.management.project.repository.UsersRepository;
import com.management.project.repository.UsersTokenRepository;
import custom.springutils.exception.CustomException;
import custom.springutils.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Service
public class UsersLoginServices extends LoginService<Users, UsersRepository> {
    @Autowired
    private UsersTokenRepository tokenRepo;

    public UsersLoginServices(UsersRepository repo) {
        super(repo);
    }

    @Override
    public boolean isConnected(String s) throws CustomException {
        UsersToken token = tokenRepo.findById(s).orElse(null);
        if (token == null) return false;
        if (token.isValidity()) {
            Timestamp now = Timestamp.valueOf(LocalDateTime.now());
            if (now.compareTo(token.getExpirationDate()) < 0) {
                logout(s);
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public void saveToken(String s, Users users) {
        UsersToken token = new UsersToken();
        token.setToken(s);
        token.setUserId(users.getId());
        token.setExpirationDate(Timestamp.valueOf(LocalDateTime.now().plusDays(7)));
        try {
            tokenRepo.save(token);
        } catch (Throwable e) {
            throw e;
        }
    }

    @Override
    public boolean logout(String s) throws CustomException {
        UsersToken token = tokenRepo.findById(s).orElse(null);
        if (token == null) throw new CustomException("user not connected");
        token.setValidity(false);
        tokenRepo.save(token);
        return true;
    }
}
