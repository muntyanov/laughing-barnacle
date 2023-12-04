package ru.tinkoff.seminars.homework.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class CategoryAttribute {

    @Id
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;

    public CategoryAttribute(String name, Category category) {
        this.name = name;
        this.category = category;
    }
}
