package com.example.taco.services;

import com.example.taco.Taco;
import com.example.taco.repositories.TacoRepository;
import com.example.taco.repositories.entities.TacoEntity;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
class TacoServiceTest {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TacoService service;

    @MockBean
    private TacoRepository repository;

    @Test
    void shouldFindAll() {
        List<TacoEntity> mocked = List.of(
                TacoEntity.builder().sku("taco1").name("taco1").price(110).build(),
                TacoEntity.builder().sku("taco2").name("taco2").price(220).build()
        );
        List<Taco> expected = mapper.map(mocked, new TypeToken<List<Taco>>() {
        }.getType());

        when(repository.findAll()).thenReturn(mocked);

        List<Taco> actual = service.findAll();

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
    }
}