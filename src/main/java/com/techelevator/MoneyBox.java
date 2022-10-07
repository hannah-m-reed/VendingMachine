package com.techelevator;

import java.math.BigDecimal;
import java.math.BigInteger;

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
            System.out.println();
            System.out.println("Insufficient funds");
            return false;
        }
    }
    public BigDecimal changeReturn(){
        double quarters = 0;
        double dimes = 0;
        double nickels = 0;
        BigDecimal changeReturned = this.currentMoney;
        BigDecimal result;

        while(this.currentMoney.compareTo(BigDecimal.valueOf(0)) > 0){

            if(this.currentMoney.compareTo(BigDecimal.valueOf(0.25)) >= 0){
                result = this.currentMoney.divide(BigDecimal.valueOf(0.25));
                quarters = Math.floor(result.doubleValue());
                result = (result.subtract(BigDecimal.valueOf(quarters))).multiply(BigDecimal.valueOf(0.25));
                currentMoney = result;

            } else if (this.currentMoney.compareTo(BigDecimal.valueOf(.1)) >= 0) {
                result = this.currentMoney.divide(BigDecimal.valueOf(0.1));
                dimes = Math.floor(result.doubleValue());
                result = (result.subtract(BigDecimal.valueOf(dimes))).multiply(BigDecimal.valueOf(0.1));
                currentMoney = result;

            } else if (this.currentMoney.compareTo(BigDecimal.valueOf(0.05)) >= 0) {
                result = this.currentMoney.divide(BigDecimal.valueOf(0.05));
                nickels = Math.floor(result.doubleValue());
                result = (result.subtract(BigDecimal.valueOf(nickels))).multiply(BigDecimal.valueOf(0.05));
                currentMoney = result;

            }

        }
        System.out.println();
        System.out.printf("Your change is Quarters: %.0f Dimes: %.0f Nickels: %.0f", quarters, dimes, nickels);
        System.out.println();
        return changeReturned;
    }
}
