package com.example.firstprojectspring.Repository;

import java.util.List;

import com.example.firstprojectspring.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
  @Query("SELECT s FROM Student s WHERE s.department.idDept =:depid")
  List<Student> findByDepartment(Integer depid);
}
