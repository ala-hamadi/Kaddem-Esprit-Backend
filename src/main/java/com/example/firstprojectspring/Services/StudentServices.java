package com.example.firstprojectspring.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstprojectspring.Models.Contract;
import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Models.Team;
import com.example.firstprojectspring.Repository.ContractRepository;
import com.example.firstprojectspring.Repository.DepartmentRepository;
import com.example.firstprojectspring.Repository.StudentRepository;
import com.example.firstprojectspring.Repository.TeamRepository;

@Service
public class StudentServices implements IServices<Student> {

  @Autowired
  private StudentRepository studentRepository;

  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private ContractRepository contractRepository;

  @Autowired
  private TeamRepository teamRepository;

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


  public void assignEtudiantToDepartement(Integer etudiantId, Integer departementId) {
    Student student = studentRepository.findById(Long.valueOf(etudiantId)).get();
    Department department = departmentRepository.findById(Long.valueOf(departementId)).get();
    //    if (student != null&&department!=null) {
    //      student.setDepartment(department);
    //      studentRepository.save(student);
    //      return true;
    //    } else {
    //      return false;
    //    }
    student.setDepartment(department);
    studentRepository.save(student);
  }

  public Student addAndAssignEtudiantToEquipeAndContract(Student e, Integer idContrat, Integer idEquipe) {
    Contract contract = contractRepository.findById(Long.valueOf(idContrat)).get();
    Team team = teamRepository.findById(Long.valueOf(idEquipe)).get();
    e.getContracts().add(contract);
    e.getTeams().add(team);
    studentRepository.save(e);
    return e;
  }

  public List<Student> getStudentByDep(Integer dep) {
    return studentRepository.findByDepartment(dep);
  }
}
