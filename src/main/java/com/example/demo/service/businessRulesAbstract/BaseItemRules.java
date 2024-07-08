package com.example.demo.service.businessRulesAbstract;

public interface BaseItemRules extends BaseRules{

    void existsByName(String name);

    void existsByNameAndIdNot(String name, int id);

}
