package com.management.project.Controller.task;

import com.management.project.Services.ProjectServices;
import com.management.project.Services.task.TaskCreatorService;
import com.management.project.Model.Project;
import com.management.project.Model.task.Task;
import custom.springutils.util.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static custom.springutils.util.ControllerUtil.returnSuccess;

@RestController
@RequestMapping("/project/{fkId}/task")
public class CreatorController {
    @Autowired
    ProjectServices projectServices;
    @Autowired
    TaskCreatorService services;

    @PostMapping("")
    public ResponseEntity<SuccessResponse> createTask(@PathVariable Long fkId, @RequestBody Task task) throws Exception {
        Project project = projectServices.findById(fkId);
        services.createNewTask(project, task.getDescription(), task.getStatus(), task.getStart_date(), task.getEnd_date(), task.getTask_order());
        return returnSuccess("Task created successfully", HttpStatus.CREATED);
    }
}
