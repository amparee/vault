package com.vault.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vault.entity.Employee;
import com.vault.service.EmployeeService;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/get-employees")
	public List<Employee> getEmployees() {
		return employeeService.listEmployee();
	}
	
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable int id) {
		return employeeService.findById(id);
	}

	@GetMapping("/get-employees-parameters")
	public List<Employee> getEmployeeJobManagerAndLastName( @RequestParam(value = "job" , required = false) int jobId,
															@RequestParam(value = "manager", required = false) int managerId,
															@RequestParam("last-name") String lastName,
															@RequestParam(value = "pagination", required = false) Optional<Integer> pagination){
		return employeeService.listEmployeeByJobManagerAndLastName(jobId, managerId, lastName, pagination);	
	}
	
	@PostMapping
	public Employee create(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@PutMapping
	public Employee update(@RequestBody Employee employee) {
		return employeeService.save(employee);
	}

	@DeleteMapping(path = { "/delete/{id}" })
	public String delete(@PathVariable("id") int id) {
		return "User was deleted: " + employeeService.delete(id);
	}

}
