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
@CrossOrigin(origins = "*")
public class TiendaController {

    @Autowired
    private TiendaService tiendaService;

    @PostMapping
    public ResponseEntity<TiendaDTO> crearTienda(@RequestBody TiendaDTO tiendaDTO) {
        TiendaDTO nuevaTienda = tiendaService.crearTienda(tiendaDTO);
        return new ResponseEntity<>(nuevaTienda, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<TiendaDTO>> listarTiendas() {
        List<TiendaDTO> tiendas = tiendaService.listarTiendas();
        return new ResponseEntity<>(tiendas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TiendaDTO> verTienda(@PathVariable Long id) {
        Optional<TiendaDTO> tiendaDTO = tiendaService.verTienda(id);
        return tiendaDTO.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
