package com.example.demo.core.exception;

import com.example.demo.core.exception.type.ValidationExceptionType;
import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException{

    private final ValidationExceptionType validationExceptionType;
    private final String detail;

    public ValidationException(ValidationExceptionType validationExceptionType, String detail){
        super(validationExceptionType.getMessage());
        this.validationExceptionType = validationExceptionType;
        this.detail = detail;
    }

    public ValidationException(ValidationExceptionType validationExceptionType){
        super(validationExceptionType.getMessage());
        this.validationExceptionType = validationExceptionType;
        this.detail = validationExceptionType.getMessage();
    }

    public String toString(){
        return "ValidationException{" +
                "error code = " + validationExceptionType.getErrorCode() +
                ", detail = " + detail + " }";
    }
}
