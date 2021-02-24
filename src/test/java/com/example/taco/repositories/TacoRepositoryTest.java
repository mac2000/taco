package com.example.taco.repositories;

import com.example.taco.repositories.entities.TacoEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class TacoRepositoryTest {
    @Autowired
    private TacoRepository repository;

    private Validator validator;

    static Stream<TacoEntity> entitiesWithBadValues() {
        return Stream.of(
                // entries with null values
                TacoEntity.builder().sku(null).name("taco").price(1).build(),
                TacoEntity.builder().sku("taco").name(null).price(1).build(),
                // entries with empty values
                TacoEntity.builder().sku("").name("taco").price(1).build(),
                TacoEntity.builder().sku("taco").name("").price(1).build(),
                // entries with strange values
                TacoEntity.builder().sku("taco").name("taco").price(-1).build(),
                TacoEntity.builder().sku("taco").name("taco").price(0).build()
        );
    }

    @BeforeEach
    public void setup() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldReturnStoredEntities() {
        Iterable<TacoEntity> actual = repository.findAll();

        int numberOfTestTacos = 6;
        assertThat(actual).hasSize(numberOfTestTacos);
    }

    @ParameterizedTest
    @MethodSource("entitiesWithBadValues")
    void shouldNotAllowSavingTacoWithInvalidData(TacoEntity taco) {
        assertThat(validator.validate(taco)).isNotEmpty();
    }
}