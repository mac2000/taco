package com.example.taco.services;

import com.example.taco.Taco;
import com.example.taco.repositories.TacoRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacoService {
    private final TacoRepository repository;
    private final ModelMapper mapper;

    public TacoService(TacoRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<Taco> findAll() {
        return mapper.map(repository.findAll(), new TypeToken<List<Taco>>() {
        }.getType());
    }

    public List<Taco> findAllById(Iterable<String> ids) {
        return mapper.map(repository.findAllById(ids), new TypeToken<List<Taco>>() {
        }.getType());
    }
}
