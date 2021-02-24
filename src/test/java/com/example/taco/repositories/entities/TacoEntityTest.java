package com.example.taco.repositories.entities;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TacoEntityTest {
    @Autowired
    TestEntityManager em;

    @Test
    void shouldHaveCorrectEqualsAndHashCode() {
        // https://thorben-janssen.com/ultimate-guide-to-implementing-equals-and-hashcode-with-hibernate/#Using_a_Generated_Primary_Key
        // arrange
        String id1 = "id1";
        String id2 = "id2";
        TacoEntity e1 = buildTaco(id1, "taco1", 110);
        TacoEntity e2 = buildTaco(id2, "taco2", 220);
        em.persistAndFlush(e1);
        em.persistAndFlush(e2);

        // 2 transient entities need to be NOT equal
        e1 = buildTaco(id1, "taco1", 110);
        e2 = buildTaco(id2, "taco2", 220);
        assertThat(e1).isNotEqualTo(e2);


        // 2 managed entities that represent different records need to be NOT equal
        e1 = em.find(TacoEntity.class, id1);
        e2 = em.find(TacoEntity.class, id2);
        assertThat(e1).isNotEqualTo(e2);

        // 2 managed entities that represent the same record need to be equal
        e1 = em.find(TacoEntity.class, id1);
        e2 = em.find(TacoEntity.class, id1);
        assertThat(e1).isEqualTo(e2);

        // a detached and a managed entity object that represent the same record need to be equal
        em.detach(e1);
        e2 = em.find(TacoEntity.class, id1);
        assertThat(e1).isEqualTo(e2);

        // a re-attached and a managed entity object that represent the same record need to be equal
        e1 = em.merge(e1);
        assertThat(e1).isEqualTo(e2);
    }

    private TacoEntity buildTaco(String sku, String name, int price) {
        TacoEntity entity = new TacoEntity();
        entity.setSku(sku);
        entity.setName(name);
        entity.setPrice(price);
        return entity;
    }
}