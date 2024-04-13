package com.veralaureano.apirest.apirest.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.veralaureano.apirest.apirest.Entities.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
