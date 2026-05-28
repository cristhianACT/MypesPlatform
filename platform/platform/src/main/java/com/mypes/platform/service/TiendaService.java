package com.mypes.platform.service;

import com.mypes.platform.dto.TiendaDTO;

public interface TiendaService {


    TiendaDTO save(TiendaDTO dto);
    TiendaDTO findById(Long id);
    TiendaDTO update(TiendaDTO dto);
    


}
