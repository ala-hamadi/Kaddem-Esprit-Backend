package com.example.firstprojectspring.Services;

import com.example.firstprojectspring.Models.Contract;
import com.example.firstprojectspring.Repository.ContractRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContractServices implements IServices<Contract> {

  @Autowired
  private ContractRepository contractRepository;


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

}
