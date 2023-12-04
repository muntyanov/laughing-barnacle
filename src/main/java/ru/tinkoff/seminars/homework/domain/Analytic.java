package ru.tinkoff.seminars.homework.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Analytic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int itemId;

    public Analytic(int itemId) {
        this.itemId = itemId;
    }
}
