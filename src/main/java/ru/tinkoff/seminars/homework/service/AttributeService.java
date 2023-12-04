package ru.tinkoff.seminars.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tinkoff.seminars.homework.domain.Attribute;
import ru.tinkoff.seminars.homework.domain.ItemAttribute;
import ru.tinkoff.seminars.homework.repository.ItemRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class AttributeService {
    ItemService service;

    public Collection<ItemAttribute> find(int categoryId, Collection<Attribute> parse) {
        return service.find(categoryId, 0, Integer.MAX_VALUE, parse).stream().flatMap(
                x -> x.getItemAttributes().stream()
        ).collect(Collectors.toList());
    }
}
