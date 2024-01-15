package com.ephemzy.springboot.tutorial.controller;

import com.ephemzy.springboot.tutorial.entity.Department;
import com.ephemzy.springboot.tutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    private final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping("/departments")
    public Department saveDepartment( @Valid @RequestBody Department department){
        LOGGER.info("Inside saveDepartment inside DepartmentController");
         return departmentService.saveDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments(){
        LOGGER.info("Inside getDepartments inside DepartmentController");
        return departmentService.getDepartments();
    }

    @GetMapping("departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId){
        LOGGER.info("Inside getDepartmentById inside DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departmentService.deleteDepartmentById(departmentId);
        LOGGER.info("Inside deleteDepartmentById inside DepartmentController");
        return "Department deleted Successfully";
    }

    @PutMapping("departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        LOGGER.info("Inside updateDepartmentById inside DepartmentController");
        return departmentService.updateDepartmentById(departmentId, department);
    }

    @GetMapping("departments/name/{name}")
    public Department getDepartmentByName(@PathVariable("name") String name) {
        LOGGER.info("Inside getDepartmentByName inside DepartmentController");
        return departmentService.getDepartmentByName(name);
    }
}
