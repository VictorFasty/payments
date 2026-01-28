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

    @PostMapping("/create")
    public ResponseEntity<Users> create(@Valid @RequestBody UsersDto dto){
        return service.create(dto);
    }


    @RequestMapping("/findall")
    public ResponseEntity<List<Users>> findAll() {
        return service.FindAll();
    }


    @RequestMapping("/{id}")
    public ResponseEntity<Users> findById(@PathVariable("id") Long id){
        return service.FindById(id);
    }

    @DeleteMapping("/{id}")
    public void Delete(Long id){
        service.Delete(id);
    }

    @PutMapping("/users/update/{id}")
    public ResponseEntity<Users> update(@PathVariable("id") Long id, @RequestBody @Valid UsersDto dto){
        return service.update(id, dto);
    }

}
