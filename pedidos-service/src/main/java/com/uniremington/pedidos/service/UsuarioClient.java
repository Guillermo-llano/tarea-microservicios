package com.uniremington.pedidos.service;

import com.uniremington.pedidos.model.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UsuarioClient {
    private final RestClient restClient;
    private final String usuariosUrl;

    public UsuarioClient(RestClient restClient, @Value("${usuarios.service.url}") String usuariosUrl) {
        this.restClient = restClient;
        this.usuariosUrl = usuariosUrl;
    }

    public Usuario buscar(Long id) {
        try {
            return restClient.get().uri(usuariosUrl + "/usuarios/" + id).retrieve().body(Usuario.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario indicado no existe");
        } catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "No fue posible consultar usuarios");
        }
    }
}
