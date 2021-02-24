package com.example.taco.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "taco")
@Data
public class TacoEntity {
    @Id
    private String sku;

    private String name;
    private int price;
}
