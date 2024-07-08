package com.example.demo.service.businessRulesAbstract;

import java.util.List;

public interface BaseRules {

    void checkDataList(List<?> list);

    String fixName(String name);

}
