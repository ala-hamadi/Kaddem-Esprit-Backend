package com.example.firstprojectspring.Services;

import com.example.firstprojectspring.Models.Contract;
import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.University;
import com.example.firstprojectspring.Repository.DepartmentRepository;
import com.example.firstprojectspring.Repository.UniversityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class DepartmentServices implements IServices<Department>{
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Override
    public Department create(Department object) {
        return departmentRepository.save(object);
    }

    @Override
    public List<Department> fetchList() {
        return departmentRepository.findAll();
    }

    @Override
    public Department fetchById(Long id) {
        Optional<Department> department=departmentRepository.findById(id);
        if (department!=null){
            return department.get();
        }else{
            return null;
        }
    }

    @Override
    public Department update(Department object) {
        Optional<Department> department=departmentRepository.findById((long) object.getIdDept());
        if (department!=null){
            departmentRepository.save(object);
            return object;
        }else{
            return null;
        }
    }

    @Override
    public Department deleteById(Long id) {
        Optional<Department> department=departmentRepository.findById(id);
        if (department!=null){
            departmentRepository.deleteById(id);
            return department.get();
        }else{
            return null;
        }
    }

    public List<Department> retrieveDepartementsByUniversite(Integer idUniversite) {
        return universityRepository.findByUniversity(idUniversite);
    }
}
