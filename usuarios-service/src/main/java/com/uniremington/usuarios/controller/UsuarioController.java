package com.uniremington.usuarios.controller;

import com.uniremington.usuarios.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong secuencia = new AtomicLong(2);

    public UsuarioController() {
        usuarios.add(new Usuario(1L, "Ana Torres", "ana@ejemplo.com"));
        usuarios.add(new Usuario(2L, "Carlos Ruiz", "carlos@ejemplo.com"));
    }

    @GetMapping
    public List<Usuario> listar() {
        return List.copyOf(usuarios);
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        return usuarios.stream().filter(u -> u.id().equals(id)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@Valid @RequestBody Usuario entrada) {
        Usuario creado = new Usuario(secuencia.incrementAndGet(), entrada.nombre(), entrada.correo());
        usuarios.add(creado);
        return creado;
    }
}
