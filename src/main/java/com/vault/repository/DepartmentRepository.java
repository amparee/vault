package com.vault.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vault.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	public Department save(Department department);
	
}
