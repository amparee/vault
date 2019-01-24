package com.vault.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vault.entity.Department;
import com.vault.entity.Employee;
import com.vault.repository.DepartmentRepository;
import com.vault.repository.EmployeeRepository;
import com.vault.repository.LocationRepository;
import com.vault.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Department save(Department department) {

		List<Department> departments = departmentRepository.findByLocationId(department.getLocation().getId());

		List<Employee> employees = new ArrayList();

		departments.parallelStream().forEach(dep -> {
			employeeRepository.findByDepartment(dep).stream().forEach(e -> employees.add(e));
		});

		Double averageSalary = employees.stream().mapToDouble(Employee::getSalary).average().orElse(Double.NaN);

		LocalDateTime date = LocalDateTime.now();

		Department departmentPersisted = new Department();

		if (averageSalary < 1000 && date.getDayOfMonth() < 15) {
			departmentPersisted = departmentRepository.save(department);
		}

		if (averageSalary < 1500 && date.getDayOfMonth() > 14) {
			departmentPersisted = departmentRepository.save(department);
		}

		return departmentPersisted;
	}

	@Override
	public List<Department> findByLocationId(int id) {
		return departmentRepository.findByLocationId(id);
	}

}
