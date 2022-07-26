package com.example.RestService.Controller;

import com.example.RestService.Models.Address;
import com.example.RestService.Repo.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressRepo addressRepo;

    @GetMapping("/getAddresses")
    public List<Address> getAddress(){
        return addressRepo.findAll();
    }

    @PutMapping(value = "update/address/{id}")
    public String updateAddress(@PathVariable long id, @RequestBody Address address){
        Address updatedAddress = addressRepo.findById(id).get();
        updatedAddress.setStreetAddress(address.getStreetAddress());
        updatedAddress.setCity(address.getCity());
        updatedAddress.setState(address.getState());
        updatedAddress.setZipCode(address.getZipCode());
        addressRepo.save(updatedAddress);
        return "Address Updated...";
    }

    @DeleteMapping(value = "/delete/address/{aid}")
    public String deleteAddress(@PathVariable long aid){
        Address deleteAddress = addressRepo.findById(aid).get();
        addressRepo.delete(deleteAddress);
        return "Deleted address with the id: " + aid;
    }
}
