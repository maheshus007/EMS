package com.codetreatise.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.LeaveData;

@Repository
public interface LeaveDataRepository extends JpaRepository<LeaveData, Integer> {

	LeaveData findByStaffId(String id);
	
	@Query("SELECT e FROM Employee e WHERE e.staffName = :searchTerm")
	List<LeaveData> findByName(@Param("searchTerm") String searchTerm);

//	User findByEmail(String email);
}
