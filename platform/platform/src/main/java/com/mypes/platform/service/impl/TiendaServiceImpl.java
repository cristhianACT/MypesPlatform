package com.mypes.platform.service.impl;

import org.springframework.stereotype.Service;

import com.mypes.platform.dto.TiendaDTO;
import com.mypes.platform.entity.Tienda;
import com.mypes.platform.repository.TiendaRepository;
import com.mypes.platform.service.TiendaService;


@Service
public class TiendaServiceImpl implements TiendaService{


    TiendaRepository tiendaRepository;

    public TiendaServiceImpl(TiendaRepository tiendaRepository) {
        this.tiendaRepository = tiendaRepository;
    }                                               

    @Override
    public TiendaDTO save(TiendaDTO dto) {

        if(dto.getNombre().isEmpty()){
            throw new RuntimeException("El nombre no puede estar vacio");                                                           
        }
        if(dto.getDireccion().isEmpty()){
            throw new RuntimeException("La direccion no puede estar vacia");
        }
        if(dto.getTelefono().isEmpty()){
            throw new RuntimeException("El telefono no puede estar vacio");
        }

        Tienda tienda = Tienda.builder()
        .nombre(dto.getNombre())
        .direccion(dto.getDireccion())
        .telefono(dto.getTelefono())
        .build();

        Tienda guardado = tiendaRepository.save(tienda);

        TiendaDTO tiendaDTO = TiendaDTO.builder()
        .tiendaId(guardado.getTiendaId())
        .nombre(guardado.getNombre())
        .direccion(guardado.getDireccion())
        .telefono(guardado.getTelefono())
        .usuarioId(guardado.getUsuario().getUsuarioId())    
        .build();  
        
        TiendaDTO respuesta = tiendaDTO;
        return respuesta;
      
    }

    @Override
    public TiendaDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public TiendaDTO update(TiendaDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

}
