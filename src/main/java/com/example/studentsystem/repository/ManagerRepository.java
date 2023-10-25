package com.example.studentsystem.repository;

import org.springframework.stereotype.Repository;

import com.example.studentsystem.model.Manager;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Integer> {

   Manager save(Manager manager);

   Manager findByName(String name);
}
