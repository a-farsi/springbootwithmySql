package com.formation.demo.web;

import com.formation.demo.dao.ProjectRepository;
import com.formation.demo.entities.Project;
import com.formation.demo.services.MapValidationErrorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
public class ProjectController {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    MapValidationErrorService mapValidationErrorService;

    @PostMapping(path="/saveProject", consumes = "application/json", produces = "application/json")
    public ResponseEntity<?> saveProject(@Valid @RequestBody Project project, BindingResult result){

        ResponseEntity<?> errorMap = mapValidationErrorService.errorValidationCheck(result);
        if(errorMap != null ) return errorMap;

        projectRepository.save(project);
        return new ResponseEntity<Project>(project, HttpStatus.CREATED);
    }
}
