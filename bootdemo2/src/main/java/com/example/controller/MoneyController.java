package com.example.controller;


import com.example.bean.Money;
import com.example.db2.service.MoneyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/money")
public class MoneyController {

    @Autowired
    private MoneyService moneyService;

    @RequestMapping("/query" )
    public Money  testQuery(){
        return  moneyService.selectMoneyById(1);
    }
}
