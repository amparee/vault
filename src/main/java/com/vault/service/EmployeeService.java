package com.vault.service;

import java.util.List;
import java.util.Optional;

import com.vault.entity.Department;
import com.vault.entity.Employee;

public interface EmployeeService {

	public abstract List<Employee> listEmployee();

	public abstract List<Employee> listEmployeeByJobManagerAndLastName(int jobId, int managerId, String lastName, int pagination);

	public abstract Employee findById(int id);

	public abstract Employee save(Employee employee);

	public abstract boolean delete(int id);
	
	public abstract List<Employee> findByDepartmentId(Department department);

}
