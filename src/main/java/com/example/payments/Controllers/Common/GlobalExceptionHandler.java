package com.example.payments.Controllers.Common;


import com.example.payments.Controllers.Common.Exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler  {

  @ExceptionHandler(NotFound.class)
  public ResponseEntity<?> handlerNotFound(NotFound e){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp: ", LocalDateTime.now());
    body.put("status: ", HttpStatus.NOT_FOUND.value());
    body.put("error ", "NOT FOUND");
    body.put("message:", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
  }


  @ExceptionHandler(Founded.class)
  public ResponseEntity<?> handlerFounded(Founded e){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp: ", LocalDateTime.now());
    body.put("status: ", HttpStatus.CONFLICT.value());
    body.put("error ", "Conflict");
    body.put("message:", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.CONFLICT);
  }


  @ExceptionHandler(InvalidUserTypeException.class)
  public ResponseEntity<?> handlerINvalidUserTypeException(InvalidUserTypeException e){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp", LocalDateTime.now());
    body.put("status", HttpStatus.FORBIDDEN.value());
    body.put("error ", "Forbidden");
    body.put("message", e.getMessage());


    return new ResponseEntity<>(body, HttpStatus.FORBIDDEN);
  }


  @ExceptionHandler(UnauthorizedTransactionException.class)
  public ResponseEntity<?> handlerUnauthorizedTransactionException(UnauthorizedTransactionException e){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp: ", LocalDateTime.now());
    body.put("status: ", HttpStatus.BAD_REQUEST.value());
    body.put("error ", "Conflict");
    body.put("message:", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
  }



  @ExceptionHandler(DuplicateDocumentException.class)
  public ResponseEntity<?> handlerDuplicateDocumentException(DuplicateDocumentException e){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp: ", LocalDateTime.now());
    body.put("status: ", HttpStatus.CONFLICT.value());
    body.put("error ", "Conflict");
    body.put("message:", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.CONFLICT);
  }

  @ExceptionHandler(EmailAlreadyExistsException.class)
  public ResponseEntity<?> handlerEmailAlreadyExistsException(EmailAlreadyExistsException e){
    Map<String, Object> body = new HashMap<>();
    body.put("timestamp: ", LocalDateTime.now());
    body.put("status: ", HttpStatus.CONFLICT.value());
    body.put("error ", "Conflict");
    body.put("message:", e.getMessage());

    return new ResponseEntity<>(body, HttpStatus.CONFLICT);
  }


}
