package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Color;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Objects;
@Component
public class CardValidation {

    public final void checkColor(String color) {
        if (    (!Objects.equals(color, Color.HEARTH.toString())
                && !Objects.equals(color, Color.SPADE.toString())
                && !Objects.equals(color, Color.CLUB.toString())
                && !Objects.equals(color, Color.DIAMOND.toString())))
        {
            throw new CardException("Color not found", HttpStatus.NOT_FOUND);
        }
    }

}
