package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionDTOs {
    private String apiPath;
    private HttpStatus statusCode;
    private String errorMessage;
    private LocalDateTime errorTime;
}
