package ru.tinkoff.seminars.homework.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int value;

    private DiscountType type;

    public double getDiscountedPrice(double price){
        if(type == DiscountType.PERCENT){
            return price * ((100 - value) / 100);
        } else {
            return price - value;
        }
    }

}
