package com.codetreatise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.AreaOfWork;

@Repository
public interface AreaOfWorkRepository extends JpaRepository<AreaOfWork, Integer> {

//	User findByEmail(String email);
}
