package ca.cloudace.backend.service;
import java.util.List;

import org.springframework.stereotype.Service;

import ca.cloudace.backend.model.Employee;
import ca.cloudace.backend.repository.EmployeeRepository;

@Service
public class EmployeeService  {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Business logic methods that use employeeRepository
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }   


    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        if (employeeRepository.existsById(id)) {
            employee.setEmployeeId(id);
            return employeeRepository.save(employee);
        }
        return null;
    }


}