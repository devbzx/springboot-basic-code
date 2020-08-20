package com.lhq.springboot.controller;

import com.lhq.springboot.bean.Department;
import com.lhq.springboot.bean.Employee;
import com.lhq.springboot.mapper.DepartmentMapper;
import com.lhq.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id")Integer id){
        return departmentMapper.getDeptById(id);
    }
    @GetMapping("/dept")
    public Department insertDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }
    @GetMapping("/depts")
    public List<Department> getAll(){
        return departmentMapper.getAllDepartments();
    }
    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id){
        return employeeMapper.getEmpById(id);
    }
}
