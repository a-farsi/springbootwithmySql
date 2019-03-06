package com.formation.demo.services;

import com.formation.demo.dao.ProjectRepository;
import com.formation.demo.entities.Project;
import com.formation.demo.exception.ProjectIdException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project saveProject(Project project){
        try{
            project.setProjectIdentifier(project.getProjectIdentifier().toUpperCase());
            return projectRepository.save(project);
        }catch (Exception exp){
            throw new ProjectIdException("Project ID "+project.getProjectIdentifier().toUpperCase()+" already exists");
        }
    }
}
