package com.vault.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vault.entity.Department;
import com.vault.service.DepartmentService;

@RestController
@CrossOrigin
@RequestMapping("/department")
public class DepartmentRestController {

	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping
	public Department create(@RequestBody Department department) {
		return departmentService.save(department);
	}
	
}
