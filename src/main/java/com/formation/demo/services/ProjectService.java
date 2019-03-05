package com.formation.demo.services;

import com.formation.demo.dao.ProjectRepository;
import com.formation.demo.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public void saveProject(Project project){
        projectRepository.save(project);
    }
}
