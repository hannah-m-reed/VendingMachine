package com.techelevator;

import java.math.BigDecimal;

public class MoneyBox {
    private BigDecimal currentMoney = new BigDecimal(0);

    public MoneyBox(){

    }

    //Method takes adds money to currentMoney if correct value and returns boolean relating success
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

    public BigDecimal getCurrentMoney() {
        return currentMoney;
    }

    //Method compares price of object to purchase with currentMoney returning boolean relating success
    public boolean makePurchase(BigDecimal price) {
        if(this.currentMoney.subtract(price).compareTo(BigDecimal.valueOf(0)) >= 0) {
            BigDecimal result = this.currentMoney.subtract(price);
            this.currentMoney = result;
            return true;
        }else{
            System.out.println("Insufficient funds");
            return false;
        }
    }
    //Method returning change (for log) and printing change in quarter, dime, and nickel quantities (the largest first) to console
    public BigDecimal changeReturn(){
        double quarters = 0;
        double dimes = 0;
        double nickels = 0;
        BigDecimal changeReturned = this.currentMoney;
        BigDecimal result;

        //While current balance is positive
        while(this.currentMoney.compareTo(BigDecimal.valueOf(0)) > 0){

            //If balance is greater than a quarter
            if(this.currentMoney.compareTo(BigDecimal.valueOf(0.25)) >= 0){
                result = this.currentMoney.divide(BigDecimal.valueOf(0.25));
                quarters = Math.floor(result.doubleValue());
                result = (result.subtract(BigDecimal.valueOf(quarters))).multiply(BigDecimal.valueOf(0.25));
                currentMoney = result;

              //If balance is greater than a dime
            } else if (this.currentMoney.compareTo(BigDecimal.valueOf(.1)) >= 0) {
                result = this.currentMoney.divide(BigDecimal.valueOf(0.1));
                dimes = Math.floor(result.doubleValue());
                result = (result.subtract(BigDecimal.valueOf(dimes))).multiply(BigDecimal.valueOf(0.1));
                currentMoney = result;
              //If balance is greater than a nickel
            } else if (this.currentMoney.compareTo(BigDecimal.valueOf(0.05)) >= 0) {
                result = this.currentMoney.divide(BigDecimal.valueOf(0.05));
                nickels = Math.floor(result.doubleValue());
                result = (result.subtract(BigDecimal.valueOf(nickels))).multiply(BigDecimal.valueOf(0.05));
                currentMoney = result;

            }

        }
        //Print result formatted to String
        System.out.println();
        System.out.printf("Your change is Quarters: %.0f Dimes: %.0f Nickels: %.0f", quarters, dimes, nickels);
        System.out.println();
        return changeReturned;
    }
}
