package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.util.CardValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@ResponseStatus(HttpStatus.OK)
public class CardController {

    private final CardRepository cardManagement;
    private CardValidation validation;
    @Autowired
    public CardController(CardRepository cardManagement) {
        this.cardManagement = cardManagement;
    }

    @GetMapping
    public List<Card> getCards() {
       return cardManagement.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getCardsByColor(@PathVariable String color) {

        return cardManagement.findByColor(color);
    }

    @PostMapping
    public Card setCard(@RequestBody Card card) {
      return cardManagement.save(card);
    }

    @PutMapping("/")
    public Card updateCard(@RequestBody Card card) {

        return cardManagement.update(card);
    }

    @DeleteMapping("/{id}")
    public Card deleteCard(@PathVariable Long id) {
        return cardManagement.remove(id);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getCardsByValue(@PathVariable Integer value) {
        return cardManagement.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getCardsByType(@PathVariable String type) {
        return cardManagement.findByType(type);
    }

}
