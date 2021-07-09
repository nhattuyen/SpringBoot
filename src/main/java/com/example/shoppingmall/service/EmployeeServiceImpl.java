package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Employee;
import com.example.shoppingmall.Repository.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> getEmployeeListByName(String name) {
        return employeeRepository.findAllByFullnameContaining(name);
    }

    @Override
    public Employee getOneEmployee(String id) {
        return employeeRepository.findEmployeesById(id);
    }

    @Override
    public void addEmployee(Employee emp) {
        Employee employee = getOneEmployee(emp.getEmpNo());
        if (employee == null) {
            employeeRepository.save(emp);
        }
    }

    @Override
    public void updateEmployee(Employee emp) {
        Employee employee = getOneEmployee(emp.getIdString());
        if (employee != null) {
            employeeRepository.save(emp);
        }
    }

    @Override
    public void deleteEmployee(String id) {
        Employee employee = getOneEmployee(id);
        if (employee != null) {
            employeeRepository.deleteById(id);
        }
    }
}
