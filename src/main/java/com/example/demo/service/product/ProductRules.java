package com.example.demo.service.product;

import com.example.demo.service.businessRulesAbstract.BaseItemRules;

import java.util.List;

public class ProductRules implements BaseItemRules {
    @Override
    public void existsByName(String name) {

    }

    @Override
    public void existsByNameAndIdNot(String name, int id) {

    }

    @Override
    public void checkDataList(List<?> list) {

    }

    @Override
    public String fixName(String name) {
        return null;
    }
}
