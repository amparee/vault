package com.vault.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vault.entity.Employee;
import com.vault.repository.EmployeeRepository;
import com.vault.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public List<Employee> listEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int id) {

		Optional<Employee> employee = employeeRepository.findById(id);
		return (employee.isPresent()) ? employee.get() : new Employee();
	}

	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public void delete(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());
		}
	}

}
