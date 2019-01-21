package com.vault.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vault.entity.Employee;
import com.vault.entity.Job;
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
			Optional<Integer> pagination) {

		int currentPage = pagination.orElse(1);
		int size = 10;
		int startItem = currentPage * size;
		List<Employee> employees;

		Employee employee = new Employee();
		Job job = new Job();

		job.setId((jobId == 0) ? jobId : null);

		employee.setJob(job);
		employee.setManagerId(managerId);
		employee.setLastName(lastName);

		employees = employeeRepository.findByJobAndManagerIdAndLastName(employee);

		employees.stream().sorted( (p1,p2) -> p1.getHireDate().compareTo(p2.getHireDate()));
		
		return employees;
	}

}
