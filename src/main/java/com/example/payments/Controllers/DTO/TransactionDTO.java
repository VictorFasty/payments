package com.example.payments.Controllers.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransactionDTO(

        @NotNull
        @Positive
        BigDecimal amount,

        @NotNull
        Long senderId,

        @NotNull
        Long receiverId

) {}
