package com.example.firstprojectspring.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstprojectspring.Models.Contract;
import com.example.firstprojectspring.Models.Student;
import com.example.firstprojectspring.Repository.ContractRepository;
import com.example.firstprojectspring.Repository.StudentRepository;

@Service
public class ContractServices implements IServices<Contract> {

  @Autowired
  private ContractRepository contractRepository;

  @Autowired
  private StudentRepository studentRepository;

  @Override
  public Contract create(Contract object) {
    return contractRepository.save(object);
  }

  @Override
  public List<Contract> fetchList() {
    return contractRepository.findAll();
  }

  @Override
  public Contract fetchById(Long id) {
    Optional<Contract> contract = contractRepository.findById(id);
    if (contract != null) {
      return contract.get();
    } else {
      return null;
    }
  }


  @Override
  public Contract update(Contract object) {
    Optional<Contract> contract = contractRepository.findById((long) object.getIdContract());
    if (contract != null) {
      contractRepository.save(object);
      return object;
    } else {
      return null;
    }
  }

  @Override
  public Contract deleteById(Long id) {
    Optional<Contract> contract = contractRepository.findById(id);
    if (contract != null) {
      contractRepository.deleteById(id);
      return contract.get();
    } else {
      return null;
    }
  }

  public Contract affectContratToEtudiant(Integer idContrat, Integer idstudent) {
    Student s = studentRepository.findById(Long.valueOf(idstudent)).get();
    Contract c = contractRepository.findById(Long.valueOf(idContrat)).get();
    c.setStudent(s);
    s.getContracts().add(c);
    contractRepository.save(c);
    studentRepository.save(s);
    return c;
  }

  //@Scheduled(cron = "* * /13 * * * *" )
  public List<Contract> retrieveAndUpdateStatusContract() {
    List<Contract> contracts = contractRepository.findAllByContractEndDate();
    for (Contract c : contracts) {
      if (c.isArchived() == false) {
        c.setArchived(true);
        contractRepository.save(c);
      }
    }
    return contracts;
  }

  public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
    return contractRepository.getChiffreAffaireEntreDeuxDate(startDate, endDate);
  }

  public Integer nbContratsValides(Date startDate, Date endDate) {
    return contractRepository.nbContratsValides(startDate, endDate);
  }
}
