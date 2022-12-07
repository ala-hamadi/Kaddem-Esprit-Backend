package com.example.firstprojectspring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Services.StudentServices;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Student Management")
@RestController
@RequestMapping("student")
public class StudentController {

  @Autowired
  private StudentServices studentServices;

  @Operation(description = "Retrive student")
  @PostMapping("/students")
  public Student saveStudent(@RequestBody Student student) {
    return studentServices.create(student);
  }

  @GetMapping("/students")
  public List<Student> fetchStudentList() {
    return studentServices.fetchList();
  }

  @GetMapping("/student/{id}")
  public Student fetchStudentById(@PathVariable("id") Long id) {
    return studentServices.fetchById(id);
  }

  @PutMapping("/student/{id}")
  public Student updateStudent(@RequestBody Student student) {
    return studentServices.update(student);
  }

  @DeleteMapping("/student/{id}")
  public Boolean deleteStudentById(@PathVariable("id") Long studentId) {
    Student student = studentServices.deleteById(studentId);
    if (student != null) {
      return true;
    } else {
      return false;
    }
  }

  @PostMapping("/addAndAssignEtudiantToEquipeAndContract/{id}/{idd}")
  public Student addAndAssignEtudiantToEquipeAndContract(@RequestBody Student student,@PathVariable("id") Integer id,@PathVariable("idd") Integer idd) {
    return studentServices.addAndAssignEtudiantToEquipeAndContract(student,id,idd);
  }

  @GetMapping("/getStudentByDep/{id}")
  public List<Student> getStudentByDep(@PathVariable("id") Integer id) {
    return studentServices.getStudentByDep(id);
  }


}
