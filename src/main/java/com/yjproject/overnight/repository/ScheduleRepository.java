package com.yjproject.overnight.repository;

import com.yjproject.overnight.domain.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ScheduleRepository {

    private final EntityManager em;

    public void save(Schedule schedule){
        em.persist(schedule);
    }

    public Schedule findOne(Long id){
        return em.find(Schedule.class,id);
    }

    public List<Schedule> findAll(){
        return em.createQuery("select s from Schedule s", Schedule.class).getResultList();
    }

    public List<Schedule> findByMonth(LocalDate month){
        LocalDate start = month.withDayOfMonth(1);
        LocalDate end = month.withDayOfMonth(month.lengthOfMonth());

        List<Schedule> result = em.createQuery("select s from Schedule s where s.date between :start and :end",Schedule.class)
                .setParameter("start", start)
                .setParameter("end", end)
                .getResultList();
        return result;
    }

}
