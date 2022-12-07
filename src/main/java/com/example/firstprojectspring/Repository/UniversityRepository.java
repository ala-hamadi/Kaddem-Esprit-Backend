package com.example.firstprojectspring.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.firstprojectspring.Models.Department;
import com.example.firstprojectspring.Models.University;

@Repository
public interface UniversityRepository extends JpaRepository<University, Long> {

  @Query("SELECT u.departments FROM University u WHERE u.idUniv =:uniid")
  List<Department> findByUniversity(Integer uniid);
}
