package com.example.demo.core.exception.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum NotFoundExceptionType {

    USER_DATA_NOT_FOUND(2000,"Kullanıcı mevcut değil"),
    USER_LIST_NOT_FOUND(2001, "Kullanıcı listesi mevcut değil"),
    EMPLOYEE_DATA_NOT_FOUND(2002, "Çalışan mevcut değil"),
    EMPLOYEE_LIST_NOT_FOUND(2003, "Çalışan listesi mevcut değil"),
    CUSTOMER_DATA_NOT_FOUND(2004, "Müşteri mevcut değil"),
    CUSTOMER_LIST_NOT_FOUND(2005, "Müşteri listesi mevcut değil"),

    PRODUCT_DATA_NOT_FOUND(2006, "Ürün mevcut değil"),
    PRODUCT_LIST_NOT_FOUND(2007, "Ürün listesi mevcut değil"),
    SALE_DATA_NOT_FOUND(2008, "Satış mevcut değil"),
    SALE_LIST_NOT_FOUND(2009, "Satış listesi mevcut değil"),
    STOCK_DATA_NOT_FOUND(2010, "Stok mevcut değil"),

    EMAIL_ADDRESS_DATA_NOT_FOUND(2011, "Email adresi mevcut değil"),
    PHONE_NUMBER_DATA_NOT_FOUND(2012, "Telefon numarası mevcut değil"),
    USER_ROLE_NOT_FOUND(2013, "Kullanıcı rolü mevcut değil");

    private final Integer errorCode;
    private final String message;

}
