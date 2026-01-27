package com.example.payments.Controllers.Mappers;

import com.example.payments.Controllers.DTO.TransactionDTO;
import com.example.payments.Model.Transaction;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    Transaction ToDTO(TransactionDTO DTO);

    TransactionDTO ToEntity(Transaction Model);
}
