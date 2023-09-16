package com.example.demo.model;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorMessage {
    public HttpStatus status;
    public String message;

    public ErrorMessage(HttpStatus notFound, String message) {
        this.status = notFound;
        this.message = message;
    }
}
