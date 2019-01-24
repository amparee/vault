package com.vault.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vault.entity.Employee;
import com.vault.repository.EmployeeRepository;
import com.vault.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final int DEFAULT_PAGINATION = 0;

	@Override
	public List<Employee> listEmployee() {
		
		List<Employee> employees = employeeRepository.findAll();
		
		employees = employees.stream().sorted((p1, p2) -> p1.getHireDate().compareTo(p2.getHireDate())).collect(Collectors.toList());
		
		return employees;
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
	public boolean delete(int id) {

		boolean deleted = false;

		Optional<Employee> employee = employeeRepository.findById(id);

		if (employee.isPresent()) {
			employeeRepository.delete(employee.get());
			deleted = true;
		}

		return deleted;

	}

	@Override
	public List<Employee> listEmployeeByJobManagerAndLastName(int jobId, int managerId, String lastName,
			int pagination) {

		int currentPage = (pagination < 0) ? DEFAULT_PAGINATION : pagination - 1;
		int size = 10;
		Pageable pageable = new PageRequest(currentPage, size);

		List<Employee> employees = null;

		employees = employeeRepository.findByJobAndManagerIdAndLastName(jobId, managerId, lastName, pageable);

		employees.stream().sorted((p1, p2) -> p1.getHireDate().compareTo(p2.getHireDate()));

		return employees;
	}

}
