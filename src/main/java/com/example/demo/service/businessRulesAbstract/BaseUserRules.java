package com.example.demo.service.businessRulesAbstract;

public interface BaseUserRules extends BaseRules{

    void existsPhoneNumber(String phoneNumber);

    void existsEmailAddress(String emailAddress);

    void existsPhoneNumberAndIdNot(String phoneNumber, int id);

    void existsEmailAddressAndIdNot(String emailAddress, int id);

}
