package com.ephemzy.springboot.tutorial.service;


import com.ephemzy.springboot.tutorial.entity.Department;
import com.ephemzy.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class DepartmentServiceImpl implements DepartmentService{

    @Autowired
    private DepartmentRepository repository;

    @Override
    public Department saveDepartment(Department department) {
        return repository.save(department);
    }

    @Override
    public List<Department> getDepartments() {
        return repository.findAll();
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return repository.findById(departmentId).orElseThrow(()-> new IllegalStateException("Student with id " + departmentId + " does not exists"));
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        boolean studentExists = repository.existsById(departmentId);
        if (!studentExists) {
            throw new IllegalStateException("Student with id " + departmentId + " does not exists");
        }
        repository.deleteById(departmentId);
    }

    @Override
    public Department updateDepartmentById(Long departmentId, Department department) {
        Department departmentDb = repository.findById(departmentId)
                .orElseThrow(() -> new IllegalStateException("Student with id " + departmentId + " does not exists"));

         if (Objects.nonNull(department.getDepartmentName())
                 && !"".equals(department.getDepartmentName())
                 &&  !departmentDb.getDepartmentName().equalsIgnoreCase(department.getDepartmentName())){
             departmentDb.setDepartmentName(department.getDepartmentName());
         }

        if (Objects.nonNull(department.getDepartmentAddress())
                && !"".equals(department.getDepartmentAddress())
                &&  !departmentDb.getDepartmentAddress().equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !"".equals(department.getDepartmentCode())
                &&  !departmentDb.getDepartmentCode().equalsIgnoreCase(department.getDepartmentCode())){
            departmentDb.setDepartmentCode(department.getDepartmentCode());
        }

        return repository.save(departmentDb);
    }

    @Override
    public Department getDepartmentByName(String name) {
        return repository.findByDepartmentNameIgnoreCase(name);
    }


}
