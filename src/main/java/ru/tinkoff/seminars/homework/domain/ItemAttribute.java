package ru.tinkoff.seminars.homework.domain;

import jakarta.persistence.*;

@Entity
public class ItemAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Item item;

    @ManyToOne
    @JoinColumn(name = "category_attribute_id")
    private CategoryAttribute categoryAttribute;

    private String value;

    public ItemAttribute(CategoryAttribute categoryAttribute, String value) {
        this.categoryAttribute = categoryAttribute;
        this.value = value;
    }

    public ItemAttribute(){}
}
