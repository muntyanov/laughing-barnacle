package ru.tinkoff.seminars.homework;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.tinkoff.seminars.homework.repository.AnalyticRepository;

@Slf4j
@Component
public class AnalyticCounter {
    @Autowired
    AnalyticRepository repository;

    @Scheduled(cron = "* * * * *")
    public void calculateCount(){
        log.info("Запустился перенос");
        rebase();
        log.info("Запустилось удаление");
        delete();
        log.info("Закончилось удаление");
    }

    @Transactional
    public void rebase(){
        repository.rebase();
    }

    @Transactional
    public void delete(){
        repository.deleteAll();
    }
}
