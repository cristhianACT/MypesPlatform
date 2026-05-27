package com.mypes.platform.service;

import com.mypes.platform.dto.TiendaDTO;
import com.mypes.platform.entity.Tienda;
import com.mypes.platform.entity.Usuario;
import com.mypes.platform.repository.TiendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TiendaService {

    @Autowired
    private TiendaRepository tiendaRepository;

    public TiendaDTO crearTienda(TiendaDTO tiendaDTO) {
        Tienda tienda = mapToEntity(tiendaDTO);
        Tienda nuevaTienda = tiendaRepository.save(tienda);
        return mapToDTO(nuevaTienda);
    }

    public List<TiendaDTO> listarTiendas() {
        return tiendaRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TiendaDTO> verTienda(Long id) {
        return tiendaRepository.findById(id).map(this::mapToDTO);
    }

    private TiendaDTO mapToDTO(Tienda tienda) {
        TiendaDTO dto = new TiendaDTO();
        dto.setId(tienda.getId());
        dto.setNombre(tienda.getNombre());
        dto.setDireccion(tienda.getDireccion());
        if (tienda.getUsuario() != null) {
            dto.setUsuarioId(tienda.getUsuario().getId());
        }
        return dto;
    }

    private Tienda mapToEntity(TiendaDTO dto) {
        Tienda tienda = new Tienda();
        tienda.setId(dto.getId());
        tienda.setNombre(dto.getNombre());
        tienda.setDireccion(dto.getDireccion());
        if (dto.getUsuarioId() != null) {
            Usuario usuario = new Usuario();
            usuario.setId(dto.getUsuarioId());
            tienda.setUsuario(usuario);
        }
        return tienda;
    }
}
