package com.srt;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {

	// native query
	@Query(value = "Select * from emp", nativeQuery = true)
	List<EmployeeDetails> getAllEmployee();

	@Query(value = "Select * from emp where ename= ?1", nativeQuery = true)
	List<EmployeeDetails> getEmployeeByName(String ename);

	@Query(value = "Select * from emp where sal= ?2 and ename= ?1", nativeQuery = true)
	List<EmployeeDetails> getEmployeeByNameAndSalary(String name, int salary);

	@Query(value = "Select * from emp where deptno= :departmentno Or ename= :name", nativeQuery = true)
	List<EmployeeDetails> getEmployeeByNameAndDeptNo(@Param("name") String name, @Param("departmentno") int deptno);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
			+ "VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)

	int insertEmployeeIndexed(long l, String ename, String job, int mgr, LocalDate hireDate, double sal,
			double comm, int deptno);

	
	@Transactional
	@Modifying
	@Query(value = "INSERT INTO emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
			+ "VALUES (:empno, :ename, :job, :mg, :hire, :salary, :commition, :deptment)", nativeQuery = true)

	int insertEmployeeNamed(
			@Param("empno") long l,
			@Param("ename") String ename, 
			@Param("job") String job,
			@Param("mg") int mgr,
			@Param("hire") LocalDate hireDate, 
			@Param("salary") double sal,
			@Param("commition") double comm,
			@Param("deptment") int deptno);

}
