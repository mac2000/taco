package com.example.taco.repositories;

import com.example.taco.repositories.entities.TacoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TacoRepository extends CrudRepository<TacoEntity, String> {
}
