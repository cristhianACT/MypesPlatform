package com.mypes.platform.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mypes.platform.dto.ProductoDTO;
import com.mypes.platform.service.ProductoService;



@RestController
@RequestMapping("/productos")                                                                       
public class ProductoController {

    ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }


    @PostMapping("/guardar")
    public ProductoDTO guardarProducto(@RequestBody ProductoDTO dto) {
        ProductoDTO respuesta = productoService.save(dto);
        return respuesta;                              
    }

    @GetMapping("/listar")
    public List<ProductoDTO> listarProductos() {
        return productoService.findAll();
    }   
    
    

}
