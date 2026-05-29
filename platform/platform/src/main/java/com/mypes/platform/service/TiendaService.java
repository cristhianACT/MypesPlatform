package com.mypes.platform.service;

import java.util.List;

import com.mypes.platform.dto.TiendaDTO;

public interface TiendaService {


    TiendaDTO save(TiendaDTO dto);
    TiendaDTO findById(Long id);
    List<TiendaDTO> findAll();
    TiendaDTO update(TiendaDTO dto);
    


}
