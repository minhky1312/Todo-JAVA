package com.example.demo.service;

import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetServiceImpl implements PetService{

    @Autowired
    private PetRepository petRepository;



    @Override
    public List<Pet>  getPet() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<Pet> pages = petRepository.findAll(pageable);
        pages.getContent();
        return (List<Pet>) petRepository.findAll();
    }

    @Override
    public void savePet(Pet pet) {
        petRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepository.deleteById(id);

    }

    @Override
    public Optional<Pet> FindpetByid(Long id) {
        return petRepository.findById(id);
    }



   // private void findByName() {
//        System.out.println(petRepository.findByName("pet 11"));
//    }
}
