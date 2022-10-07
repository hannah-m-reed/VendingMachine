package com.techelevator;

import java.math.BigDecimal;

public class MoneyBox {
    private BigDecimal currentMoney = new BigDecimal(0);

    public MoneyBox(){

    }
    public boolean feedMoney(BigDecimal money){


        if(money.equals(BigDecimal.valueOf(10))) {
            BigDecimal result = this.currentMoney.add(money);
            this.currentMoney = result;
            return true;
        }else if (money.equals(BigDecimal.valueOf(5))) {
            BigDecimal result = this.currentMoney.add(money);
            this.currentMoney = result;
            return true;
        }else if (money.equals(BigDecimal.valueOf(1))) {
            BigDecimal result = this.currentMoney.add(money);
            this.currentMoney = result;
            return true;
        }else{
            return false;
        }
    }
    public String getCorrectChange(){
        String changeReturned = "";
        if(currentMoney.remainder(BigDecimal.valueOf(1)).compareTo(BigDecimal.valueOf(1)) >= 0){

        }
        return changeReturned;
    }

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    public boolean setCurrentMoney(BigDecimal currentMoney) {
        if(this.currentMoney.subtract(currentMoney).compareTo(BigDecimal.valueOf(0)) >= 0) {
            BigDecimal result = this.currentMoney.subtract(currentMoney);
            this.currentMoney = result;
            return true;
        }else{
            System.out.println("Insufficient funds");
            return false;
        }
    }
}
