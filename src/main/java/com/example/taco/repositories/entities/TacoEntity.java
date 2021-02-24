package com.example.taco.repositories.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import java.util.Objects;

@Entity
@Table(name = "taco")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TacoEntity {
    @Id
    @NotBlank
    private String sku;

    @NotBlank
    private String name;

    @Positive
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
