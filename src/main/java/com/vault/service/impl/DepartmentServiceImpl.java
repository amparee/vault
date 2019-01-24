package com.vault.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vault.entity.Department;
import com.vault.repository.DepartmentRepository;
import com.vault.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Override
	public Department save(Department department) {
		return departmentRepository.save(department);
	}

	
}
