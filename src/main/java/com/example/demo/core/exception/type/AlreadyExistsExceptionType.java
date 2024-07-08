package com.example.demo.core.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum AlreadyExistsExceptionType {

    USER_ALREADY_EXISTS(1000, "Kullanıcı zaten mevcut"),
    EMPLOYEE_ALREADY_EXISTS(1001, "Çalışan zaten mevcut"),
    CUSTOMER_ALREADY_EXISTS(1002, "Müşteri zaten mevcut"),

    PRODUCT_ALREADY_EXISTS(1003, "Ürün zaten mevcut"),
    SALE_ALREADY_EXISTS(1004, "Satış zaten mevcut"),

    EMAIL_ADDRESS_ALREADY_EXISTS(1005, "Email adresi zaten mevcut"),
    PHONE_NUMBER_ALREADY_EXISTS(1006, "Telefon numarası zaten mevcut");

    private final Integer errorCode;
    private final String message;

}
