package com.codetreatise.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.codetreatise.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Employee findByStaffId(String id);
	
	@Query("SELECT e FROM Employee e WHERE e.staffName = :searchTerm")
	List<Employee> findByName(@Param("searchTerm") String searchTerm);

	@Query("SELECT e FROM Employee e WHERE e.areaofwork = :searchTerm")
	List<Employee> findByAreaOfWork(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.uaeId = :searchTerm")
	List<Employee> findByUAEID(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.linemanager = :searchTerm")
	List<Employee> findByLineManager(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.email = :searchTerm")
	List<Employee> findByEmail(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.batch = :searchTerm")
	List<Employee> findByBatch(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.contact = :searchTerm")
	List<Employee> findByContact(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.designation = :searchTerm")
	List<Employee> findByDesignation(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.passport = :searchTerm")
	List<Employee> findByPassport(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.drivingLicense = :searchTerm")
	List<Employee> findByLicense(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.department = :searchTerm")
	List<Employee> findByDepartment(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.doj = :searchTerm")
	List<Employee> findByDoj(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.ojtstartdate = :searchTerm")
	List<Employee> findByOjtStart(@Param("searchTerm") Date searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.ojtenddate = to_char(:searchTerm,'yyyy-MM-dd')")
	List<Employee> findByOjtEnd(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.NSstatus = :searchTerm")
	List<Employee> findByNsStatus(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.NSstartdate = :searchTerm")
	List<Employee> findByNsStart(@Param("searchTerm") String searchTerm);
	
	@Query("SELECT e FROM Employee e WHERE e.NS_end_date = :searchTerm")
	List<Employee> findByNsEnd(@Param("searchTerm") String searchTerm);

//	User findByEmail(String email);
}
