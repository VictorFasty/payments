package com.example.payments.Controllers;

import com.example.payments.Controllers.DTO.UsersDto;
import com.example.payments.Model.Users;
import com.example.payments.Services.UsersService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UsersController {

    private final UsersService service;

    @PostMapping("/users/create")
    public ResponseEntity<Users> create(@Valid @RequestBody UsersDto dto){
        return service.create(dto);
    }


    @PostMapping("/users/findall")
    public ResponseEntity<List<Users>> findAll() {
        return service.FindAll();
    }


    @PostMapping("/users/{id}")
    public ResponseEntity<Users> findById(@PathVariable("id") Long id){
        return service.FindById(id);
    }

    @DeleteMapping("/users/{id}")
    public void Delete(Long id){
        service.Delete(id);
    }

    


}
