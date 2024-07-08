package com.example.demo.core.exception;

import com.example.demo.core.exception.type.AlreadyExistsExceptionType;
import lombok.Getter;

@Getter
public class AlreadyExistsException extends RuntimeException{

    private final AlreadyExistsExceptionType alreadyExistsExceptionType;
    private final String detail;

    public AlreadyExistsException(AlreadyExistsExceptionType alreadyExistsExceptionType, String detail) {
        super(alreadyExistsExceptionType.getMessage());
        this.alreadyExistsExceptionType = alreadyExistsExceptionType;
        this.detail = detail;
    }

    public AlreadyExistsException(AlreadyExistsExceptionType alreadyExistsExceptionType){
        super(alreadyExistsExceptionType.getMessage());
        this.alreadyExistsExceptionType = alreadyExistsExceptionType;
        this.detail = alreadyExistsExceptionType.getMessage();
    }

    @Override
    public String toString() {
        return "AlreadyException{" +
        "error code = " + alreadyExistsExceptionType.getErrorCode() +
        ", detail = " + detail + " } "       ;
    }

}
