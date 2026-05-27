package com.mypes.platform.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Producto {

    private Long id;
    private String nombre;
    private double precio;
    private int stock;
    


}
