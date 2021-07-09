package com.example.shoppingmall.service;

import com.example.shoppingmall.Entity.Employee;

import java.util.List;

public interface IEmployeeService {
    Iterable<Employee> getAll();

    List<Employee> getEmployeeListByName(String name);

    Employee getOneEmployee(String id);

    void addEmployee(Employee emp);

    void updateEmployee(Employee emp);

    void deleteEmployee(String id);
}
