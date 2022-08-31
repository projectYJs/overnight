package com.yjproject.overnight.repository;

import com.yjproject.overnight.domain.Schedule;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class ScheduleRepositoryTest {

    @Autowired
    ScheduleRepository scheduleRepository;

    @Test
    @Transactional
//    @Rollback(value = false)
    void save(){
        //given
        Schedule schedule = new Schedule();
        schedule.setDate(LocalDate.now());
        scheduleRepository.save(schedule);

        //when
        Schedule find = scheduleRepository.findOne(schedule.getId());

        //then
        Assertions.assertThat(schedule).isEqualTo(find);
    }

    @Test
    @Transactional
    @Rollback(value = false)
    void 기간조회테스트(){
        //given
        LocalDate now = LocalDate.now();
        Schedule schedule1 = new Schedule();
        schedule1.setDate(now);
        scheduleRepository.save(schedule1);

        Schedule schedule2 = new Schedule();
        schedule2.setDate(now.plusMonths(1));
        scheduleRepository.save(schedule2);

        Schedule schedule3 = new Schedule();
        schedule3.setDate(now.minusDays(20));
        scheduleRepository.save(schedule3);

        //when
        List<Schedule> byMonth = scheduleRepository.findByMonth(now);

        //then
        for (Schedule schedule : byMonth) {
            System.out.println("schedule.getDate() = " + schedule.getDate());
        }
        Assertions.assertThat(byMonth).contains(schedule1,schedule3);
        Assertions.assertThat(byMonth).doesNotContain(schedule2);
    }

}