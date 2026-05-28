package com.mypes.platform.dto;

import lombok.Data;

@Data
public class TiendaDTO {

    private Long tiendaId;

    private String nombre;

    private String direccion;

    private String telefono;

    private Long usuarioId;

}