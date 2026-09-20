package com.uniremington.pedidos.controller;

import com.uniremington.pedidos.model.Usuario;
import com.uniremington.pedidos.service.UsuarioClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PedidoController.class)
class PedidoControllerTest {
    @Autowired MockMvc mvc;
    @MockBean UsuarioClient usuarioClient;

    @Test
    void creaPedidoConDatosDelUsuario() throws Exception {
        when(usuarioClient.buscar(1L)).thenReturn(new Usuario(1L, "Ana Torres", "ana@ejemplo.com"));

        mvc.perform(post("/pedidos")
                        .contentType("application/json")
                        .content("{\"producto\":\"Teclado\",\"valor\":120000,\"usuarioId\":1}"))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.usuario.nombre").value("Ana Torres"));
    }
}
