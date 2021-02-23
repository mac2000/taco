package com.example.taco.services;

import com.example.taco.Taco;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TacoService {
    public List<Taco> findAll() {
        return List.of();
    }
}
