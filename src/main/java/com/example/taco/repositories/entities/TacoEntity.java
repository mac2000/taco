package com.example.taco.repositories.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "taco")
@Data
public class TacoEntity {
    @Id
    private String sku;

    @NotBlank
    private String name;

    @NotNull
    private int price;

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof TacoEntity) {
            TacoEntity other = (TacoEntity) obj;
            return Objects.equals(this.sku, other.sku);
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.sku);
    }
}
