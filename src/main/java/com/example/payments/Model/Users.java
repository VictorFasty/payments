package com.example.payments.Model;

import com.example.payments.Model.Enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
@Table(name = "tb_users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String nome;

    @Column(length = 14)
    private String documento;

    @Column(length = 35)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_usuario")
    private TipoUsuario tipoUsuario;

    @Column(precision = 10, scale = 2)
    private BigDecimal saldo;
}
