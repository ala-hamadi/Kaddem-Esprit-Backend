package com.example.firstprojectspring.Repository;

import com.example.firstprojectspring.Models.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepository<University,Long> {

}
