package com.example.payments.Services;

import com.example.payments.Controllers.DTO.UsersDto;
import com.example.payments.Controllers.Mappers.UsersMapper;
import com.example.payments.Model.Users;
import com.example.payments.Repositories.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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


    

}
