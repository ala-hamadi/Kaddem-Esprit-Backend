package com.example.firstprojectspring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Repository.StudentRepository;

@Service
public class StudentServices implements IServices<Student> {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private DepartmentServices departmentServices;
  @Override
  public Student create(Student object) {
    return studentRepository.save(object);
  }

  @Override
  public List<Student> fetchList() {
    return studentRepository.findAll();
  }

  @Override
  public Student fetchById(Long id) {
    Optional<Student> student = studentRepository.findById(id);
    if (student != null) {
      return student.get();
    } else {
      return null;
    }
  }

  @Override
  public Student update(Student object) {
    Optional<Student> student = studentRepository.findById((long) object.getIdStudent());
    if (student != null) {
      studentRepository.save(object);
      return object;
    } else {
      return null;
    }
  }

  @Override
  public Student deleteById(Long id) {
    Optional<Student> student = studentRepository.findById(id);
    if (student != null) {
      studentRepository.deleteById(id);
      return student.get();
    } else {
      return null;
    }
  }

  public Boolean assignStudentToDepartement (Long etudiantId, Long departementId){
    Optional<Student> student=studentRepository.findById(etudiantId);
    Department department=departmentServices.fetchById(departementId);

    if (student != null&&department!=null) {
      student.get().setDepartment(department);
      studentRepository.save(student.get());
      return true;
    } else {
      return false;
    }
  }
}
