package ru.tinkoff.seminars.homework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tinkoff.seminars.homework.domain.Analytic;
import ru.tinkoff.seminars.homework.repository.AnalyticRepository;

@Service
public class AnalyticService {

    @Autowired
    AnalyticRepository analyticRepository;

    public void see(int itemId){
        analyticRepository.save(new Analytic(itemId));
    }
}
