package com.example.payments.Controllers;

import com.example.payments.Controllers.DTO.TransactionDTO;
import com.example.payments.Model.Transaction;
import com.example.payments.Services.TransactionalService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionalService service;

    @PostMapping
    public ResponseEntity<Transaction> create(@RequestBody @Valid TransactionDTO dto) throws Exception {
        return service.create(dto);
    }




}
