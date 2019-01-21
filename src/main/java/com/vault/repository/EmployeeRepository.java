package com.vault.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vault.entity.Employee;

@SuppressWarnings("unchecked")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	public void delete(Employee employee);

	public List<Employee> findAll();
	
	public List<Employee> findByJobAndManagerIdAndLastName(Employee employee);

	public Optional<Employee> findById(int employee);

	public Employee save(Employee employee);

}
