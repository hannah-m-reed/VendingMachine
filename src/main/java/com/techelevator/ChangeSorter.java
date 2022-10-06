package com.techelevator;

import java.math.BigDecimal;

public class ChangeSorter {
    private BigDecimal currentMoney = new BigDecimal(0);

    public ChangeSorter(){

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
