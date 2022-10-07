package com.techelevator;

import java.math.BigDecimal;

public class MoneyBox {
    private BigDecimal currentMoney = new BigDecimal(0);

    public MoneyBox(){

    }
    public BigDecimal feedMoney(){
        this.currentMoney.add(BigDecimal.valueOf(1.00));
        return currentMoney;
    }
    public String getCorrectChange(){
        String changeReturned = "";
        if(currentMoney.remainder(BigDecimal.valueOf(1)).compareTo(BigDecimal.valueOf(1)) >= 0){

        }
        return changeReturned;
    }
}
