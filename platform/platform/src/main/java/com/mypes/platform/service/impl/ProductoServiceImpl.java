package com.mypes.platform.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mypes.platform.dto.ProductoDTO;
import com.mypes.platform.entity.Producto;
import com.mypes.platform.entity.Tienda;
import com.mypes.platform.repository.ProductoRepository;
import com.mypes.platform.repository.TiendaRepository;
import com.mypes.platform.service.ProductoService;


@Service
public class ProductoServiceImpl implements ProductoService {



    private final ProductoRepository productoRepository;
    
    private final TiendaRepository tiendaRepository;



    public ProductoServiceImpl(ProductoRepository productoRepository, TiendaRepository tiendaRepository) {
        this.productoRepository = productoRepository;
        this.tiendaRepository = tiendaRepository;
    }

    @Override
    public ProductoDTO save(ProductoDTO dto) {

        if(dto.getPrecio() < 0){
        throw new RuntimeException("El precio no puede ser negativo");
        }

        if(dto.getStock() < 0){
            throw new RuntimeException("El stock no puede ser negativo");
            }

        if(dto.getNombre() == null || dto.getNombre().trim().isEmpty()){
            throw new RuntimeException("El nombre no puede estar vacio");
            }

        Tienda tienda = tiendaRepository.findById(dto.getTiendaId())
        .orElseThrow(() -> new RuntimeException("Tienda no encontrada"));


        Producto producto = Producto.builder()
        .tienda(tienda)
        .nombre(dto.getNombre())
        .precio(dto.getPrecio())
        .stock(dto.getStock())
        .build();
       
        Producto guardado = productoRepository.save(producto);


        ProductoDTO productoDTO = ProductoDTO.builder()
        .tiendaId(guardado.getTienda().getTiendaId())
        .productoId(guardado.getProductoId())
        .nombre(guardado.getNombre())
        .precio(guardado.getPrecio())
        .stock(guardado.getStock())
        .build();       
        return productoDTO;
    }

    @Override
    public List<ProductoDTO> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public ProductoDTO findById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public ProductoDTO update(ProductoDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }



}
