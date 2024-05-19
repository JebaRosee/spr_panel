package com.example.Myproject.Myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Myproject.Myproject.model.EmployeeModel;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeModel,Integer> {

}
