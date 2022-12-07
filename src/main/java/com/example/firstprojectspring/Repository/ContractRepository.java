package com.example.firstprojectspring.Repository;

import java.util.Date;
import java.util.List;

import com.example.firstprojectspring.Models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<Contract,Long> {

  @Query("SELECT c FROM Contract c WHERE DATEDIFF (c.contractEndDate,current_date) <= 15")
  List<Contract> findAllByContractEndDate();

  @Query("SELECT sum(c.contractAmount) FROM Contract c WHERE c.contractStartDate>=:startDate and c.contractEndDate<=:endDate and c.archived=false group by c.specialty")
  Float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate);

  @Query("SELECT count(c) FROM Contract c WHERE c.contractStartDate>=:startDate and c.contractEndDate<=:endDate and c.archived=true")
  Integer nbContratsValides(Date startDate, Date endDate);

}
