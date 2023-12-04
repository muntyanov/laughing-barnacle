package ru.tinkoff.seminars.homework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.seminars.homework.domain.Category;
import ru.tinkoff.seminars.homework.service.AttributeService;
import ru.tinkoff.seminars.homework.service.CategoryService;
import ru.tinkoff.seminars.homework.service.ItemService;

import java.util.List;

@RestController
public class CategoryController {

	private CategoryService categoryService;

	@Autowired
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@RequestMapping("cats")
	public List<Category> find(){
		return categoryService.findAll();
	}
}
