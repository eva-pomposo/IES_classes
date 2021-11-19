package com.lab3_2.lab3_2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lab3_2.lab3_2.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    public Employee findByEmailId(String emailId);
}