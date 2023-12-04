package ru.tinkoff.seminars.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tinkoff.seminars.homework.domain.Analytic;

@Repository
public interface AnalyticRepository extends JpaRepository<Analytic, Integer> {
    @Query(value = """
            insert into analytic_counts
            select item_id , count(*) as c from analytic
            group by item_id
            on conflict do update set count = excluded.count + c
            """, nativeQuery = true)
    void rebase();
}
