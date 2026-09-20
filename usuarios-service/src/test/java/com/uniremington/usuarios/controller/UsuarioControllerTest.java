package com.uniremington.usuarios.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UsuarioController.class)
class UsuarioControllerTest {
    @Autowired MockMvc mvc;

    @Test
    void consultaUsuarioExistente() throws Exception {
        mvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Ana Torres"));
    }

    @Test
    void usuarioInexistenteRetorna404() throws Exception {
        mvc.perform(get("/usuarios/99")).andExpect(status().isNotFound());
    }
}
