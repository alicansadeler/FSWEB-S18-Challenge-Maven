package com.workintech.fswebs18challengemaven.repository;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.entity.Color;

import java.util.List;

public interface CardRepository {
   Card save(Card card);
   List<Card> findByColor(String color);
   List<Card> findAll();
   List<Card> findByValue(Integer value);
   List<Card> findByType(String type);
   Card update(Card card);
   Card remove(Long id);
   Card findById(Long id);
}
