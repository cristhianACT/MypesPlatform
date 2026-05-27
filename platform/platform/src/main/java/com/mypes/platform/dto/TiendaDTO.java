package com.mypes.platform.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TiendaDTO {
    private Long id;
    private String nombre;
    private String direccion;
    private Long usuarioId;
}
