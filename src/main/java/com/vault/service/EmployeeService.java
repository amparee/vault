package com.vault.service;

import java.util.List;

import com.vault.entity.Employee;

public interface EmployeeService {

	public abstract List<Employee> listEmployee();

	public abstract Employee findById(int id);

	public abstract Employee save(Employee employee);

	public abstract void delete(Long id);

}
