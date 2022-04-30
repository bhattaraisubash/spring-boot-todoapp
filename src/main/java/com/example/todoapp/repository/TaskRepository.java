package com.example.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoapp.model.Task;

/**
 * @author subash
 * @since Apr 30, 2022
 */
public interface TaskRepository extends JpaRepository<Task, Long>{

}
