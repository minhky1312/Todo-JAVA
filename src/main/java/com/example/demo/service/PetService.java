package com.example.demo.service;


import com.example.demo.model.Pet;

import java.util.List;
import java.util.Optional;


public interface PetService {

    List<Pet> getPet();


    void savePet(Pet pet);

    void deletePet(Long id);


    Optional<Pet> FindpetByid(Long id);
}
