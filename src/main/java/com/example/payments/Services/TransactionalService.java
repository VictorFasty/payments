package com.example.payments.Services;

import com.example.payments.Controllers.Common.Exceptions.NotFound;
import com.example.payments.Controllers.DTO.TransactionDTO;
import com.example.payments.Controllers.Mappers.TransactionMapper;
import com.example.payments.Model.Transaction;
import com.example.payments.Model.Users;
import com.example.payments.Repositories.TransactionRepository;
import com.example.payments.Repositories.UsersRepository;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TransactionalService {

    private final TransactionMapper mapper;
    private final TransactionRepository repository;
    private final UsersService usersService;
    private final UsersRepository usersRepository;

    @Transactional
    public ResponseEntity<Transaction> create(TransactionDTO dto) throws Exception {
        Transaction transaction1 = mapper.ToEntity(dto);
        Users sender = usersService.FindById(dto.senderId()).getBody();
        Users receive = usersService.FindById(dto.receiverId()).getBody();

        usersService.validateTransaction(sender, dto.amount());
        sender.setSaldo(sender.getSaldo().subtract(dto.amount()));

        receive.setSaldo(receive.getSaldo().add(dto.amount()));
        usersRepository.save(sender);
        usersRepository.save(receive);

        transaction1.setSender(sender);
        transaction1.setReceiver(receive);

        Transaction transactionSaved = repository.save(transaction1);

        return ResponseEntity.status(HttpStatus.CREATED).body(transactionSaved);
    }

    public ResponseEntity<Transaction> FindById(Long id){
        Optional<Transaction> transaction1 = repository.findById(id);

        if(transaction1.isEmpty()) {
            throw new NotFound("Transacao nao localizada!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(transaction1.get());
    }


    public ResponseEntity<Transaction> update(Transaction transaction){
        if(repository.findById(transaction.getId()).isEmpty()){
            throw new NotFound("Transacao nao encontrada");
        }
        repository.save(transaction);
        return ResponseEntity.ok().build();
    }

    public void Delete(Long id){
        repository.deleteById(id);
    }


}
