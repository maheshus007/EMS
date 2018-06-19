package com.codetreatise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Employee;
import com.codetreatise.bean.User;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

//	User findByEmail(String email);
}
