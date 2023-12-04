package ru.tinkoff.seminars.homework.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.tinkoff.seminars.homework.domain.Item;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {

    @Query("select i from Item i where i.category.id = :categoryId" )
    List<Item> findByCategory(int categoryId, PageRequest pageble);
    List<Item> findByCategoryId(int categoryId);
}
