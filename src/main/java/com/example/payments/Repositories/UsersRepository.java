package com.example.payments.Repositories;

import com.example.payments.Model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> FindBydocumento(String documento);

    boolean findByDocumento(String documento);

    boolean findByEmail(String email);
}
