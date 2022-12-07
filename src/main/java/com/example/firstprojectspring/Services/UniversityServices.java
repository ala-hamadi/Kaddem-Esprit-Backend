package com.example.firstprojectspring.Services;

import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Models.Team;
import com.example.firstprojectspring.Models.University;
import com.example.firstprojectspring.Repository.DepartmentRepository;
import com.example.firstprojectspring.Repository.UniversityRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UniversityServices implements IServices<University> {

  @Autowired
  private UniversityRepository universityRepository;

    @Autowired
    private DepartmentRepository departmentRepository;
  @Autowired
  private DepartmentServices departmentServices;

  @Autowired
  private UniversityServices universityServices;
  @Override
  public University create(University object) {
    return universityRepository.save(object);
  }

  @Override
  public List<University> fetchList() {
    return universityRepository.findAll();
  }

  @Override
  public University fetchById(Long id) {
    Optional<University> university = universityRepository.findById(id);
    if (university != null) {
      return university.get();
    } else {
      return null;
    }
  }

  @Override
  public University update(University object) {
    Optional<University> university = universityRepository.findById((long) object.getIdUniv());
    if (university != null) {
      universityRepository.save(object);
      return object;
    } else {
      return null;
    }
  }


  @Override
  public University deleteById(Long id) {
    Optional<University> university = universityRepository.findById(id);
    if (university != null) {
      universityRepository.deleteById(id);
      return university.get();
    } else {
      return null;
    }
  }
  public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
    Department department=departmentServices.fetchById(Long.valueOf(idDepartement));
    University university=universityServices.fetchById(Long.valueOf(idUniversite));
    university.getDepartments().add(department);
    universityServices.create(university);
  }
}
