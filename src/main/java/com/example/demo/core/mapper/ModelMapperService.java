package com.example.demo.core.mapper;

import org.modelmapper.ModelMapper;

public interface ModelMapperService {

    ModelMapper forRequest();

    ModelMapper forResponse();

}
