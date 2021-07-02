package com.tasky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasky.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
