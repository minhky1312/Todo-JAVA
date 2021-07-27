package com.example.demo.controller;

import com.example.demo.model.Customer;
import com.example.demo.model.Pet;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.PetRepository;
import com.example.demo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.demo.service.PetServiceImpl;

import java.util.List;
import java.util.Optional;

@Controller
public class PetController {


//     private PetService petService;


     private  PetServiceImpl petService;

    public PetController(PetServiceImpl petService) {
        this.petService = petService;
    }

    //     @Autowired private PetRepository petRepository;

//   @Autowired
//   private PetRepository petRepository;
////
////    public PetController(PetService petService) {
////
////
////    }
//
//    @Autowired
//    private CustomerRepository customerRepository;

    @Autowired
    private CustomerServiceImpl customerService;


    @GetMapping("/petss")
    public String getAllPets(Model model) {

        List<Customer> customers = customerService.getCustomer();

        model.addAttribute("petss", customers);
        return "view-pet";
    }

    @GetMapping("/login")
    public String login(Model model) {

//        List<Customer> customers = customerService.getCustomer();
//
//        model.addAttribute("petss", customers);
        return "login";
    }

        @GetMapping("/petsindex")
        public String index(Model model ) {
        List<Pet> pets = petService.getPet();
        model.addAttribute("petss", pets);
        return "petsindex";
    }

    @GetMapping("/pets")
    public String indexx(Model model )
    {
        List<Customer> customers = customerService.getCustomer();

        model.addAttribute("cus", customers);
        return "index";
    }

    @GetMapping("/petsss")
    public String indexxxx(Model model )
    {
        List<Customer> customers = customerService.getCustomer();

        model.addAttribute("cus", customers);
        return "index";
    }


    @GetMapping(value = "add")
    public String addPet(Model model) {
        model.addAttribute("petss", new Pet());
        return "petadd";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editPet(@RequestParam("id") Long petid, Model model) {
        Optional<Pet> petedit = petService.FindpetByid(petid);
        petedit.ifPresent(pet -> model.addAttribute("petss", pet));
        return "editpet";
    }

    @RequestMapping(value = "save2", method = RequestMethod.POST)
    public String save(Pet pet) {
        petService.savePet(pet);
        return "redirect:pets";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteCustomer(@RequestParam("id") Long cusid, Model model) {
        customerService.deleteCustomer(cusid);
        return "redirect:pets";
    }

    @RequestMapping(value = "/customeredit", method = RequestMethod.GET)
    public String editCustomer(@RequestParam("id") Long cusid, Model model) {
        Optional<Customer> customeredit =customerService.FindCustomerByid(cusid);
        customeredit.ifPresent(customer -> model.addAttribute("cus", customer));
        return "editcustomer";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)

    public String saveCustomer(Customer customer) {
        customerService.saveCustomer(customer);
        return "redirect:pets";
    }




}
