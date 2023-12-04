package ru.tinkoff.seminars.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.tinkoff.seminars.homework.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
