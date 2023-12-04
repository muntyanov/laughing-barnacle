package ru.tinkoff.seminars.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.seminars.homework.domain.Category;
import ru.tinkoff.seminars.homework.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
