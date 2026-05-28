package com.mypes.platform.controller;

import com.mypes.platform.dto.TiendaDTO;
import com.mypes.platform.service.TiendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tiendas")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @PostMapping
    public ResponseEntity<TiendaDTO> createTienda(@RequestBody TiendaDTO tiendaDTO) {
        TiendaDTO createdTienda = tiendaService.crearTienda(tiendaDTO);
        return new ResponseEntity<>(createdTienda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> listTiendas() {
        List<TiendaDTO> tiendas = tiendaService.listarTiendas();
        return new ResponseEntity<>(tiendas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> getTienda(@PathVariable Long id) {
        Optional<TiendaDTO> tienda = tiendaService.verTienda(id);
        return tienda.map(t -> new ResponseEntity<>(t, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
