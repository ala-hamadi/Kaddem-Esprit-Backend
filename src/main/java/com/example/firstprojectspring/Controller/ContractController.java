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

import com.example.firstprojectspring.Models.Contract;
import com.example.firstprojectspring.Services.ContractServices;

@RestController
public class ContractController {

  @Autowired
  private ContractServices contractServices;

  @PostMapping("/contracts")
  public Contract saveContact(@RequestBody Contract contract) {
    return contractServices.create(contract);
  }

  @GetMapping("/contracts")
  public List<Contract> fetchContractList() {
    return contractServices.fetchList();
  }

  @GetMapping("/contract/{id}")
  public Contract fetchContractById(@PathVariable("id") Long id) {
    return contractServices.fetchById(id);
  }


  @PutMapping("/contact/{id}")
  public Contract updateContract(@RequestBody Contract contract) {
    return contractServices.update(contract);
  }

  @DeleteMapping("/contract/{id}")
  public Boolean deleteContactById(@PathVariable("id") Long contractId) {
    Contract contract = contractServices.deleteById(contractId);
    if (contract != null) {
      return true;
    } else {
      return false;
    }
  }
}
