package com.management.project.Controller;

import com.management.project.Model.Users;
import com.management.project.Services.UsersServices.UsersCrudServices;
import com.management.project.Services.UsersServices.UsersLoginServices;
import custom.springutils.controller.LoginController;
import custom.springutils.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static custom.springutils.util.ControllerUtil.returnSuccess;

@RestController
@RequestMapping("/users")
public class UsersController extends LoginController<Users, UsersLoginServices> {
    @Autowired
    UsersCrudServices servicesusers;
    public UsersController(UsersLoginServices service) {
        super(service);
    }

    @Override
    public String getRequestHeaderKey() {
        return "users_token";
    }
    @PostMapping
    public ResponseEntity<?> signup (@RequestBody Users user) throws CustomException{
        return returnSuccess(this.servicesusers.create(user), HttpStatus.OK);
    }
}