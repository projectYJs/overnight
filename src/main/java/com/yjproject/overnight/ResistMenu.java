package com.yjproject.overnight;

import com.yjproject.overnight.domain.item.*;
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
        sampleClass.makeSample();
    }

    @Component
    @RequiredArgsConstructor
    @Transactional
    static class MakeItem {

        private final EntityManager em;

        public void makeSample(){
            Oatmeal oatmeal1 = getOatmeal("오트밀", 10000, 100, OatmealType.ROLLED_OAT);
            em.persist(oatmeal1);
            Oatmeal oatmeal2 = getOatmeal("즉석 오트밀", 10000, 100, OatmealType.INSTANT_OAT);
            em.persist(oatmeal2);

            Yogurt yogurt1 = getYogurt("그릭", 10000, 100, YogurtType.GREEK_YOGURT);
            em.persist(yogurt1);
            Yogurt yogurt2 = getYogurt("플레인", 10000, 100, YogurtType.PLAIN_YOGURT);
            em.persist(yogurt2);

            Topping topping1 = getTopping("딸기", 3000, 100, ToppingType.FRUITS);
            em.persist(topping1);
            Topping topping2 = getTopping("초코시럽", 3000, 100, ToppingType.SYRUPS);
            em.persist(topping2);
            Topping topping3 = getTopping("아몬드", 3000, 100, ToppingType.NUTS);
            em.persist(topping3);

            Product product = new Product();
            product.setOatmeal(oatmeal1);
            product.setYogurt(yogurt1);
            product.setTopping(topping1);
            em.persist(product);

        }

        private Oatmeal getOatmeal(String name, int price, int stockQuantity, OatmealType rolledOat1) {
            Oatmeal oatmeal1 = new Oatmeal();
            oatmeal1.setName(name);
            oatmeal1.setPrice(price);
            oatmeal1.setStockQuantity(stockQuantity);
            oatmeal1.setOatmealType(rolledOat1);
            return oatmeal1;
        }

        private Yogurt getYogurt(String name, int price, int stockQuantity, YogurtType greekYogurt1) {
            Yogurt yogurt1 = new Yogurt();
            yogurt1.setName(name);
            yogurt1.setPrice(price);
            yogurt1.setStockQuantity(stockQuantity);
            yogurt1.setYogurtType(greekYogurt1);
            return yogurt1;
        }

        private Topping getTopping(String name, int price, int stockQuantity, ToppingType fruits1) {
            Topping topping1 = new Topping();
            topping1.setName(name);
            topping1.setPrice(price);
            topping1.setStockQuantity(stockQuantity);
            topping1.setToppingType(fruits1);
            return topping1;
        }

    }

}
