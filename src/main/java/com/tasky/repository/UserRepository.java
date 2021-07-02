package com.tasky.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tasky.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
