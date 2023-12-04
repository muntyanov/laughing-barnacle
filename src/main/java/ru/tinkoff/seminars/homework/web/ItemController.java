package ru.tinkoff.seminars.homework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.tinkoff.seminars.homework.domain.Item;
import ru.tinkoff.seminars.homework.service.AttributeService;
import ru.tinkoff.seminars.homework.service.ItemService;
import ru.tinkoff.seminars.homework.utils.FilterParser;

import java.util.Collection;

@RestController
public class ItemController {

	private ItemService itemService;

	private AttributeService attributeService;
	@Autowired
	public ItemController(ItemService itemService, AttributeService attributeService) {
		this.itemService = itemService;
		this.attributeService = attributeService;
	}

	@RequestMapping("/item/{id}")
	public Item findItemById(
			@PathVariable("id") String id
	) {
		return itemService.find(id);
	}

	@RequestMapping("/items")
	public Collection<Item> findItemsWithFilter(
			@RequestParam int categoryId,
			@RequestParam int page,
			@RequestParam int size,
			@RequestParam(required = false) String filter
	) {
		if(categoryId == 0)
			return itemService.find(
					page,
					size,
					new FilterParser().parse(filter)
			);
		return itemService.find(
				categoryId,
				page,
				size,
				new FilterParser().parse(filter)
		);
	}
}
