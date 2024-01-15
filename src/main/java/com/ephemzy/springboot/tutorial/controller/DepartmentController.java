package com.ephemzy.springboot.tutorial.controller;

import com.ephemzy.springboot.tutorial.entity.Department;
import com.ephemzy.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/departments")
    public Department saveDepartment( @Valid @RequestBody Department department){
         return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        return departmentService.getDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        return "Department deleted Successfully";
    }

    @PutMapping("departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        return departmentService.getDepartmentByName(name);
    }
}
