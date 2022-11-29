package com.example.firstprojectspring.Repository;

import com.example.firstprojectspring.Models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {


}
