package com.ephemzy.springboot.tutorial.service;

import com.ephemzy.springboot.tutorial.entity.Department;

import java.util.List;

public interface DepartmentService {
    public Department saveDepartment(Department department);

    List<Department> getDepartments();

    Department getDepartmentById(Long departmentId);

    void deleteDepartmentById(Long departmentId);

    Department updateDepartmentById(Long departmentId, Department department);

    Department getDepartmentByName(String name);
}
