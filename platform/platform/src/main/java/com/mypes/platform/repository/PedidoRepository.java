package com.mypes.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mypes.platform.entity.Pedidos;

public interface PedidoRepository extends JpaRepository<Pedidos, Long> {


}
