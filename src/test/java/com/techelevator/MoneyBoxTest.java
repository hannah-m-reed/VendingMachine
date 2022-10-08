package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MoneyBoxTest {
    private MoneyBox moneyBox;

    @Before
    public void setup(){
        moneyBox = new MoneyBox();
    }

    @After
    public void teardown(){

    }

    @Test
    public void feedMoney_test10_returnsCorrectValueAndBoolean(){
        //Arrange
        Boolean expected = true;
        BigDecimal expectedMoney = BigDecimal.valueOf(10);
        //Act
        Boolean actual = moneyBox.feedMoney(BigDecimal.valueOf(10));
        BigDecimal actualMoney = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMoney,actualMoney);
    }

    @Test
    public void feedMoney_test1_returnsCorrectValueAndBoolean(){
        //Arrange
        Boolean expected = true;
        BigDecimal expectedMoney = BigDecimal.valueOf(1);
        //Act
        Boolean actual = moneyBox.feedMoney(BigDecimal.valueOf(1));
        BigDecimal actualMoney = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMoney,actualMoney);
    }

    @Test
    public void feedMoney_testNegative100_returnsCorrectValueAndBoolean(){
        //Arrange
        Boolean expected = false;
        BigDecimal expectedMoney = BigDecimal.valueOf(0);
        //Act
        Boolean actual = moneyBox.feedMoney(BigDecimal.valueOf(-100));
        BigDecimal actualMoney = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedMoney,actualMoney);
    }

    @Test
    public void getCurrentMoney_returns_correctValue(){
        //Arrange
        BigDecimal expected = BigDecimal.valueOf(5);
        moneyBox.feedMoney(BigDecimal.valueOf(5));
        //Act
        BigDecimal actual = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makePurchase_testNegative10_returns_correctValue_andFalse(){
        //Arrange
        BigDecimal expectedMoney = BigDecimal.valueOf(0);
        //Act
        Boolean actualBoolean= moneyBox.makePurchase(BigDecimal.valueOf(10));
        BigDecimal actualMoney = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertFalse(actualBoolean);
        Assert.assertEquals(expectedMoney, actualMoney);
    }

    @Test
    public void makePurchase_testZero_returns_correctValue_andTrue(){
        //Arrange
        BigDecimal expectedMoney = BigDecimal.valueOf(0);
        //Act
        Boolean actualBoolean= moneyBox.makePurchase(BigDecimal.valueOf(0));
        BigDecimal actualMoney = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertTrue(actualBoolean);
        Assert.assertEquals(expectedMoney, actualMoney);
    }

    @Test
    public void makePurchase_test10_returns_correctValue_andTrue(){
        //Arrange
        BigDecimal expectedMoney = BigDecimal.valueOf(0);
        moneyBox.feedMoney(BigDecimal.valueOf(10));
        //Act
        Boolean actualBoolean= moneyBox.makePurchase(BigDecimal.valueOf(10));
        BigDecimal actualMoney = moneyBox.getCurrentMoney();
        //Assert
        Assert.assertTrue(actualBoolean);
        Assert.assertEquals(expectedMoney, actualMoney);
    }

    @Test
    public void changeReturn_test0Returned_returnsCorrectBigDecimal(){
        //Arrange
        BigDecimal expectedBD = BigDecimal.valueOf(0);
        //Act
        BigDecimal actualBD = moneyBox.changeReturn();
        //Assert
        Assert.assertEquals(expectedBD, actualBD);
    }


    @Test
    public void changeReturn_test5Returned_returnsCorrectBigDecimal(){
        //Arrange
        BigDecimal expectedBD = BigDecimal.valueOf(5);
        moneyBox.feedMoney(BigDecimal.valueOf(5));
        //Act
        BigDecimal actualBD = moneyBox.changeReturn();
        //Assert
        Assert.assertEquals(expectedBD, actualBD);
    }
}
