package com.uniremington.pedidos.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record NuevoPedido(
        @NotBlank String producto,
        @NotNull @DecimalMin("0.01") BigDecimal valor,
        @NotNull Long usuarioId) {
}
