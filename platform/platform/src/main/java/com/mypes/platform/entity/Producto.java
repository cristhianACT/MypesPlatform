package com.mypes.platform.entity;

<<<<<<< HEAD
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
=======
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
>>>>>>> seguridad
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
<<<<<<< HEAD
@Builder
@Table(name="tbl_producto")
public class Producto {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String nombre;
    @Column(nullable=false)
    private double precio;
    @Column(nullable=false)
    private Integer stock;
=======
public class Producto {

    private Long id;
    private String nombre;
    private double precio;
    private int stock;
>>>>>>> seguridad
    


}
