package com.uniremington.pedidos.controller;

import com.uniremington.pedidos.model.NuevoPedido;
import com.uniremington.pedidos.model.Pedido;
import com.uniremington.pedidos.model.Usuario;
import com.uniremington.pedidos.service.UsuarioClient;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
    private final UsuarioClient usuarioClient;
    private final List<Pedido> pedidos = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong();

    public PedidoController(UsuarioClient usuarioClient) {
        this.usuarioClient = usuarioClient;
    }

    @GetMapping
    public List<Pedido> listar() {
        return List.copyOf(pedidos);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Pedido crear(@Valid @RequestBody NuevoPedido entrada) {
        Usuario usuario = usuarioClient.buscar(entrada.usuarioId());
        Pedido pedido = new Pedido(secuencia.incrementAndGet(), entrada.producto(), entrada.valor(), usuario);
        pedidos.add(pedido);
        return pedido;
    }
}
