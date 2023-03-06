package com.management.project.Controller.task;


import com.management.project.Services.task.TaskAssignUserService;
import custom.springutils.util.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static custom.springutils.util.ControllerUtil.returnSuccess;

@RestController
@RequestMapping("/task")
public class AssignUserToTask {
    @Autowired
    TaskAssignUserService assignUserTaskService;

    @PutMapping("/users/{fkId}/{taskid}")
    public ResponseEntity<SuccessResponse> assignUserToTask(@PathVariable("fkId") Long userId, @PathVariable("taskid") Long taskId) {
        assignUserTaskService.assignUserToTask(userId, taskId);
        return returnSuccess("User assign to task successfully", HttpStatus.CREATED);
    }
}
