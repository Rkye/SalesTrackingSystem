package com.example.demo.controller;

import lombok.Builder;

@Builder(builderMethodName = "tResponseBuilder")
public record TResponse<T>(T response) //-> DTO nesnesini buraya göndereceğiz.
{

}
