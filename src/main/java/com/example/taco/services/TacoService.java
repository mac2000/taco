package com.example.taco.services;

import com.example.taco.Taco;
import com.example.taco.services.interfaces.TacoServiceInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacoService implements TacoServiceInterface {
    @Override
    public List<Taco> findAll() {
        return List.of();
    }
}
