package com.example.RestService.Controller;

import com.example.RestService.Models.Card;
import com.example.RestService.Models.User;
import com.example.RestService.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserRepo userRepo;

    @PostMapping("/signup")
    public ResponseEntity<String> saveUser(@RequestBody List<User> userData){
        userRepo.saveAll(userData);
        return ResponseEntity.ok("Data saved");
    }

    @GetMapping(value = "/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }

    @GetMapping(value = "/user/{id}")
    User one(@PathVariable Long id) {
        return userRepo.findById(id).get();
    }


    @PutMapping(value = "update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        //updatedUser.setEmail(user.getEmail());
        updatedUser.setPassword(user.getPassword());
        updatedUser.setName(user.getName());
        updatedUser.setAddress(user.getAddress());
        updatedUser.setCards(user.getCards());
        userRepo.save(updatedUser);
        return "Updated...";
    }


    @PutMapping(value = "/update/account/{id}")
    public String updateAcc(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setPassword(user.getPassword());
        updatedUser.setName(user.getName());
        userRepo.save(updatedUser);
        return "Account updated...";
    }

    @PutMapping(value = "user/addCard/{id}")
    public String addCard(@PathVariable long id, @RequestBody User user){
        User updatedUser = userRepo.findById(id).get();
        updatedUser.setCards(user.getCards());
        userRepo.save(updatedUser);
        return "Card Appended...";
    }

    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        User deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);
        return "Deleted user with the id: " + id;
    }

}
