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
@Table(name="tbl_pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private int cantidad;
    @Column(nullable=false)
    private String estado;

}
        
=======
public class Pedidos {

    private Long id;
    private int cantidad;
    private String estado;

}
>>>>>>> seguridad
