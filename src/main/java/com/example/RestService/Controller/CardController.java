package com.example.RestService.Controller;

import com.example.RestService.Models.Card;
import com.example.RestService.Repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CardController {

    @Autowired
    private CardRepo cardRepo;

    @GetMapping("/getCards")
    public List<Card> getCards(){
        return cardRepo.findAll();
    }

    @DeleteMapping(value = "/delete/card/{cid}")
    public String deleteCard(@PathVariable long cid){
        Card deleteCard = cardRepo.findById(cid).get();
        cardRepo.delete(deleteCard);
        return "Deleted card with the id: " + cid;
    }

    @PutMapping(value = "update/card/{id}")
    public String updateCard(@PathVariable long id, @RequestBody Card card){
        Card updatedCard = cardRepo.findById(id).get();
        updatedCard.setNumber(card.getNumber());
        updatedCard.setCvv(card.getCvv());
        updatedCard.setExp(card.getExp());
        updatedCard.setNetwork(card.getNetwork());
        cardRepo.save(updatedCard);
        return "Card Updated...";
    }
}
