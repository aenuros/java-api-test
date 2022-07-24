package com.example.RestService.Controller;

import com.example.RestService.Models.Address;
import com.example.RestService.Repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping("/getAddresses")
    public List<Address> getAddress(){
        return addressRepo.findAll();
    }

    @DeleteMapping(value = "/delete/address/{aid}")
    public String deleteAddress(@PathVariable long aid){
        Address deleteAddress = addressRepo.findById(aid).get();
        addressRepo.delete(deleteAddress);
        return "Deleted card with the id: " + aid;
    }
}
