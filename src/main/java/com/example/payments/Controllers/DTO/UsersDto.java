package com.example.payments.Controllers.DTO;

import com.example.payments.Model.Enums.TipoUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record UsersDto(
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 5, max = 18)
        String senha,
        TipoUsuario tipoUsuario,
        BigDecimal saldo
) {
}
