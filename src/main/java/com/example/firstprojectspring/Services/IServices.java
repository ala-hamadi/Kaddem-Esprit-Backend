package com.example.firstprojectspring.Services;

import java.util.List;

public interface IServices <T>{
    //T : Contact, Department,Stud,Team,Univ


    // Save operation
    //Create T & return T
    T create(T object);

    // Read list operation
    //return T list if exist else list null
    List<T> fetchList();

    // Read operation by id
    //return T  if exist else null
    T fetchById(Long id);

    // Update operation
    //modify T & return T  if exist else null
    T update(T object);

    // Delete operation
    //Delete T & return true
    // if exist else false
    T deleteById(Long id);
}
