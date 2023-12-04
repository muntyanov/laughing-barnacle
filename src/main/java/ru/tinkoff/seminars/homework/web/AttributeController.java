package ru.tinkoff.seminars.homework.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.tinkoff.seminars.homework.domain.ItemAttribute;
import ru.tinkoff.seminars.homework.service.AttributeService;
import ru.tinkoff.seminars.homework.utils.FilterParser;

import java.util.Collection;

@RestController
public class AttributeController {

	@Autowired
	private AttributeService attributeService;

	@RequestMapping("/attributes")
	public Collection<ItemAttribute> findAttributes(
			@RequestParam int categoryId,
			@RequestParam(required = false) String filter
	) {
		return attributeService.find(
				categoryId,
				new FilterParser().parse(filter)
		);
	}
}
