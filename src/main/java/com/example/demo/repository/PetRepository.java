package com.example.demo.repository;

import com.example.demo.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetRepository extends JpaRepository<Pet, Long> {

//    List<Pet> findByName(String name);
//
//    List<Pet> findByNamen(int age);
//
//
//
//    @Query("select pet from Pet pet where pet.name = ?1 and pet.age = ?2")
//    List<Pet> findByNameAndAge(String name, int age);

}
