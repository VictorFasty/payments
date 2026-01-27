package com.example.payments.Controllers.DTO;

import com.example.payments.Model.Enums.TipoUsuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.NumberFormat;

import java.math.BigDecimal;

public record UsersDto(
        @NotBlank
        @Size(min = 5, max = 100)
        String nome,

        @NotBlank
        @Size(min = 11, max = 14)
        String documento,

        @NotBlank
        @Email
        String email,

        @NotBlank
        @Size(min = 5, max = 18)
        String senha,

        @NotNull
        TipoUsuario tipoUsuario,

        @NotNull
        @PositiveOrZero
        BigDecimal saldo
) {
}
