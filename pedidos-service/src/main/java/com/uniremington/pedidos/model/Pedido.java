package com.uniremington.pedidos.model;

import java.math.BigDecimal;

public record Pedido(Long id, String producto, BigDecimal valor, Usuario usuario) {
}
