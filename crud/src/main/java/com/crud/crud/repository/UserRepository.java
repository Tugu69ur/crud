package com.crud.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crud.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}