package com.vault.service;

import java.util.List;

import com.vault.entity.Department;

public interface DepartmentService {

	public abstract Department save(Department department);
	public abstract List<Department> findByLocationId(int id);

}
