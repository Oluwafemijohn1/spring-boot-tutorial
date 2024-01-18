package com.ephemzy.springboot.tutorial.service;


import com.ephemzy.springboot.tutorial.entity.Department;
import com.ephemzy.springboot.tutorial.error.DepartmentNotFoundException;
import com.ephemzy.springboot.tutorial.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
    public Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException {
        Optional<Department> department =  repository.findById(departmentId);
         if (!department.isPresent()){
             throw new DepartmentNotFoundException("Department Not Available");
         }
         return department.get();
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
                 && !department.getDepartmentName().isEmpty()
                 &&  !departmentDb.getDepartmentName().equalsIgnoreCase(department.getDepartmentName())){
             departmentDb.setDepartmentName(department.getDepartmentName());
         }

        if (Objects.nonNull(department.getDepartmentAddress())
                && !department.getDepartmentAddress().isEmpty()
                &&  !departmentDb.getDepartmentAddress().equalsIgnoreCase(department.getDepartmentAddress())){
            departmentDb.setDepartmentAddress(department.getDepartmentAddress());
        }

        if (Objects.nonNull(department.getDepartmentCode())
                && !department.getDepartmentCode().isEmpty()
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
