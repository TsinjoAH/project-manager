package com.management.project.controller;

import com.management.project.Services.ProjectServices;
import com.management.project.Services.UsersCrudServices;
import com.management.project.model.Project;
import com.management.project.model.Users;
import custom.springutils.util.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static custom.springutils.util.ControllerUtil.returnSuccess;

@RestController
@RequestMapping("/users/{fkId}/project")
public class ProjectController {
    @Autowired
    UsersCrudServices userService;
    @Autowired
    ProjectServices services;
    @PostMapping("")
    public ResponseEntity<SuccessResponse> createAuction(@PathVariable Long fkId, @RequestBody Project project) throws Exception{
        Users fk = this.userService.findById(fkId);
        project.setFK(fk);
        return returnSuccess(this.services.create(project), HttpStatus.CREATED);
    }
}