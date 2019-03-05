package com.formation.demo.dao;

import com.formation.demo.entities.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long> {
}

