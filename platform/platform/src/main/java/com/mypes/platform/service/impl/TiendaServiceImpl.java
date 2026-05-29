package com.mypes.platform.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypes.platform.dto.TiendaDTO;
import com.mypes.platform.entity.Tienda;
import com.mypes.platform.entity.Usuario;
import com.mypes.platform.repository.TiendaRepository;
import com.mypes.platform.repository.UsuarioRepository;
import com.mypes.platform.service.TiendaService;


@Service
public class TiendaServiceImpl implements TiendaService{


    TiendaRepository tiendaRepository;
    UsuarioRepository usuarioRepository;
                     

    public TiendaServiceImpl(TiendaRepository tiendaRepository, UsuarioRepository usuarioRepository) {
        this.tiendaRepository = tiendaRepository;
        this.usuarioRepository = usuarioRepository;
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

        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())                                            
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));    

        Tienda tienda = Tienda.builder()
        .nombre(dto.getNombre())
        .direccion(dto.getDireccion())
        .telefono(dto.getTelefono())
        .usuario(usuario)
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

    @Override
    public List<TiendaDTO> findAll() {

        List<Tienda> listaTiendas = tiendaRepository.findAll();

        

        


        return null;
    }

    

}
