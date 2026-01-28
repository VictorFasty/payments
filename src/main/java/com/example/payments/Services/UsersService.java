package com.example.payments.Services;

import com.example.payments.Controllers.DTO.UsersDto;
import com.example.payments.Controllers.Mappers.UsersMapper;
import com.example.payments.Model.Enums.TipoUsuario;
import com.example.payments.Model.Users;
import com.example.payments.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UsersService {

    private final UsersRepository repository;
    private final UsersMapper mapper;

    public ResponseEntity<Users> create(UsersDto dto){
        Users users1 = mapper.toEntity(dto);
        if(repository.findByDocumento(users1.getDocumento())) {
            throw new RuntimeException("Documento Ja Existente");
        }

        if(repository.findByEmail(users1.getEmail())){
            throw new RuntimeException("Email ja vinculado");
        }

        Users UserSaved = repository.save(users1);

        return ResponseEntity.status(HttpStatus.CREATED).body(UserSaved);
    }


    public ResponseEntity<List<Users>> FindAll() {
        return ResponseEntity.status(HttpStatus.OK).body(repository.findAll());
    }


    public ResponseEntity<Users> FindById(Long id){
        Optional<Users> users0 = repository.findById(id);
        if(users0.isEmpty()) {
            throw new RuntimeException("Usuario Nao Localizado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(users0.get());
    }


    public ResponseEntity<Users> update(Long id, UsersDto dto) {

        Users existingUser = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario nao existente"));

        if (repository.existsByEmailAndIdNot(dto.email(), id)) {
            throw new RuntimeException("Email ja esta registrado!");
        }

        if (repository.existsByDocumentoAndIdNot(dto.documento(), id)) {
            throw new RuntimeException("Documento ja esta registrado!");
        }

        existingUser.setNome(dto.nome());
        existingUser.setEmail(dto.email());


        repository.save(existingUser);
        return ResponseEntity.ok(existingUser);
    }


    public void Delete(Long id){
        repository.deleteById(id);

    }


    public void validateTransaction(Users sender, BigDecimal amount) throws Exception {
        if (sender.getTipoUsuario() == TipoUsuario.MERCHANT) {
            throw new Exception("Lojistas não podem enviar dinheiro.");
        }

        if (sender.getSaldo().compareTo(amount) < 0) {
            throw new Exception("Saldo insuficiente");
        }
    }
}
