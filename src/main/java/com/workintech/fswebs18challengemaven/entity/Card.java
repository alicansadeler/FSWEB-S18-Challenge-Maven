package com.workintech.fswebs18challengemaven.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Card", schema = "public")
public class Card {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private Long  id;

     @Column(name = "value")
     private Integer  value;

     @Enumerated(EnumType.STRING)
     @Column(name = "type")
     private Type type;

    @Enumerated(EnumType.STRING)
    @Column(name = "color")
     private Color color;


    public Card(Long id, Integer value, Type type, Color color) {
        this.id = id;
        type_value_check(value,type,color);
    }

    private void type_value_check(Integer value, Type type, Color color) {
        if (type == Type.JOKER) {
            this.value = null;
            this.color = null;
            this.type = type;
        } else {
            if (value != null) {
                this.value = value;
                this.color = color;
                this.type = null;
            } else {
                this.value = null;
                this.color = color;
                this.type = type;
            }
        }
    }

}
