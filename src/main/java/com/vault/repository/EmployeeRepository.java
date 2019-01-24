package com.vault.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vault.entity.Department;
import com.vault.entity.Employee;

@SuppressWarnings("unchecked")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public void delete(Employee employee);

	public List<Employee> findAll();

	@Query("Select e From Employee e Where job_id = :jobId AND manager_id = :managerId AND last_name = :lastName")
	public List<Employee> findByJobAndManagerIdAndLastName(@Param("jobId") Integer jobId,
			@Param("managerId") Integer managerId, @Param("lastName") String lastName,
			Pageable pageable);

	public Optional<Employee> findById(int employee);

	public Employee save(Employee employee);

	public List<Employee> findByDepartment(Department department);
	
}
