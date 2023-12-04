package ru.tinkoff.seminars.homework.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;
    private double price;
    private String name;

    public double getPrice() {
        if(discount.isEmpty() || discount == null)
            return price;
        var pricetemp = price;
        for (var disc:discount) {
            pricetemp = disc.getDiscountedPrice(pricetemp);
        }
        return pricetemp;
    }

    @ManyToMany
    @JoinTable(name = "item_discount")
    private List<Discount> discount;

    @OneToMany(mappedBy = "item")
    private Collection<ItemAttribute> itemAttributes;
}
