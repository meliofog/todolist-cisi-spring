package com.example.todov1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todov1.entities.Tasks;

public interface TasksRepo extends JpaRepository<Tasks, Long> {

    @Override
   List<Tasks>findAll();

}
