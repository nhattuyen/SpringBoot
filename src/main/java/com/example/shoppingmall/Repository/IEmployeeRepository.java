package com.example.shoppingmall.Repository;

import com.example.shoppingmall.Entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

    Employee findEmployeesById(String id);
    List<Employee>findAllByFullnameContaining(String fullname);
    List<Employee>findEmployeesByIdAndFullname(String id, String fullname);
    List<Employee>findAllByEmpNoIsNotNull();
    List<Employee>findEmployeesByHireDateGreaterThan(Date hiredate);
    boolean existsByEmpNo(String empno);
    int deleteById(String id);

}
