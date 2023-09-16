package com.springUdemyCourse.OrderService.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CustomException extends  RuntimeException{
    private String errorCode;
    private int status;

    public CustomException(String message, String errorCode,int status){
        super(message);
        this.errorCode = errorCode;
        this.status = status;
    }
}
