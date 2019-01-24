package com.vault.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vault.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	public List<Department> findByLocationId(int locationId);

	public Department save(Department department);
	
}
