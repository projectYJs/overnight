package com.yjproject.overnight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Component
public class SampleMaker {


    private final MakeSample sampleClass;

    @PostConstruct
    public void init(){
        sampleClass.makeMember();
    }

    @Component

    @RequiredArgsConstructor
    @Transactional
    static class MakeSample {

        private final EntityManager em;

        public void makeMember(){

        }

        public void makeOrder(){

        }

    }

}
