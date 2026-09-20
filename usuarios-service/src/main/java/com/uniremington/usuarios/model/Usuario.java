package com.uniremington.usuarios.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record Usuario(Long id, @NotBlank String nombre, @NotBlank @Email String correo) {
}
