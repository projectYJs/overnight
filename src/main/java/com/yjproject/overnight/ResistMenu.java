package com.yjproject.overnight;

import com.yjproject.overnight.domain.item.Item;
import com.yjproject.overnight.domain.item.Oatmeal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class ResistMenu {

    private final MakeItem sampleClass;

    @PostConstruct
    public void init(){
        sampleClass.makeOatmeals();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class MakeItem {

        private final EntityManager em;

        public void makeOatmeals(){
            Item test = new Oatmeal();
            test.setName("오트밀");
            test.setPrice(10000);
            test.setStockQuantity(100);
            em.persist(test);

            Item test2 = new Oatmeal();
            test2.setName("즉석 오트밀");
            test2.setPrice(10000);
            test2.setStockQuantity(100);
            em.persist(test2);
        }

    }

}
