package com.example.payments.Controllers.Mappers;

import com.example.payments.Controllers.DTO.UsersDto;
import com.example.payments.Model.Users;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    Users ToDto(Users model);
    Users toEntity(UsersDto dto);
}
