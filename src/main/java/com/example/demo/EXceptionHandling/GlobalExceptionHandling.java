package com.example.demo.EXceptionHandling;

import com.example.demo.DTO.ExceptionDTOs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandling {
   @ExceptionHandler(UserAlreadyThere.class)
    public ResponseEntity<?> HandlingUserLAlreadyThere(UserAlreadyThere ex, WebRequest webRequest){
       ExceptionDTOs exceptionDTO = new ExceptionDTOs(
               webRequest.getDescription(false),
               HttpStatus.CONFLICT,
               ex.getMessage(),
               LocalDateTime.now()
       );
       return ResponseEntity.status(HttpStatus.CONFLICT).body(exceptionDTO);
   }
   @ExceptionHandler(UserNotThere.class)
    public ResponseEntity<?> HandlingUserNotThere(UserNotThere ex, WebRequest webRequest){
       ExceptionDTOs exceptionDTO = new ExceptionDTOs(
               webRequest.getDescription(false),
               HttpStatus.NOT_FOUND,
               ex.getMessage(),
               LocalDateTime.now()
       );
       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
   }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> HandlingOtherExceptions(Exception ex, WebRequest webRequest){
        ExceptionDTOs exceptionDTO = new ExceptionDTOs(
                webRequest.getDescription(false),
                HttpStatus.NOT_FOUND,
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }
}
