package com.example.firstprojectspring.Controller;

import com.example.firstprojectspring.Models.Contract;
import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Services.DepartmentServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

  @Autowired
  private DepartmentServices departmentServices;

  @PostMapping("/departments")
  public Department saveDepartement(@RequestBody Department department) {
    return departmentServices.create(department);
  }

  @GetMapping("/departments")
  public List<Department> fetchDepartmentList() {
    return departmentServices.fetchList();
  }

  @GetMapping("/department/{id}")
  public Department fetchDepartmentById(@PathVariable("id") Long id) {
    return departmentServices.fetchById(id);
  }

  @PutMapping("/department/{id}")
  public Department updateDepartment(@RequestBody Department department) {
    return departmentServices.update(department);
  }

  @DeleteMapping("/department/{id}")
  public Boolean deleteDepartmentById(@PathVariable("id") Long departmentId) {
      Department department = departmentServices.deleteById(departmentId);
      if (department != null) {
          return true;
      } else {
          return false;
      }
  }
}
