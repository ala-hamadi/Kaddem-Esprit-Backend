package com.example.firstprojectspring.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstprojectspring.Models.University;
import com.example.firstprojectspring.Services.UniversityServices;

@RestController
public class UniversityController {

  @Autowired
  private UniversityServices universityServices;

  @PostMapping("/create-university")
  public University save(@RequestBody University object) {
    return universityServices.create(object);
  }

  @GetMapping("/get-universities")
  public List<University> fetchList() {
    return universityServices.fetchList();
  }

  @GetMapping("/get-university/{id}")
  public University fetchUniversityById(@PathVariable("id") Long id) {
    return universityServices.fetchById(id);
  }

  @PutMapping("/update-university")
  public University update(@RequestBody University object) {
    return universityServices.update(object);
  }

  @DeleteMapping("/delete-university/{id}")
  public Boolean deleteById(@PathVariable Long id) {
    University university = universityServices.deleteById(id);
    if (university != null) {
      return true;
    } else {
      return false;
    }
  }
}
