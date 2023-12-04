package ru.tinkoff.seminars.homework.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import ru.tinkoff.seminars.homework.domain.Attribute;
import ru.tinkoff.seminars.homework.domain.Item;
import ru.tinkoff.seminars.homework.repository.ItemRepository;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    EntityManagerFactory emf;

    public Item find(String id) {
        return itemRepository.findById(Integer.parseInt(id)).get();
    }


    public List<Item> find(int categoryId, int page, int size, Collection<Attribute> parse) {
        var em = emf.createEntityManager();
        final AtomicInteger i = new AtomicInteger(0);
        return em.createNativeQuery(
                "select i.* from items as i " +
                        parse.stream().map(a -> "join item_attribute as ia" + i.incrementAndGet() +" on ia.item_id = i.id " +
                                "and ia.value = '" + a.getValue() + "' join cate as category_attribute as ca" + i.incrementAndGet()
                                + " on name = '" + a.getName() + "'") +" where i.category_id = " +categoryId +"  limit " + size + " OFFSET " + page*size , Item.class
        ).getResultList();
    }

    @Cacheable
    public List<Item> find(int page, int size, Collection<Attribute> parse) {
        var em = emf.createEntityManager();
        final AtomicInteger i = new AtomicInteger(0);
        return em.createNativeQuery(
                "select i.* from items as i " +
                        parse.stream().map(a -> {
                            var q = i.incrementAndGet();
                            return "join item_attribute as ia" + q +" on ia.item_id = i.id " +
                                    "and ia" + q +".value = '" + a.getValue() + "' join category_attribute as ca" + q
                                    + " on ca" + q +".name = '" + a.getName() + "'";
                        }).collect(Collectors.joining(" ")) +" limit " + size + " OFFSET " + page*size , Item.class
        ).getResultList();
    }
    public Collection<Item> find(int categoryId, int page, int size) {
        return itemRepository.findByCategory(categoryId,
                PageRequest.of(page, size));
    }

}
