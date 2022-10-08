package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CandyTest {
    private Candy candy;

    @Before
    public void setup(){
        candy = new Candy("test", BigDecimal.valueOf(1.05));
    }

    @After
    public void teardown(){

    }
    @Test
    public void getPhrase_returns_phrase(){
        //Arrange
        String expected = "Munch Munch, Yum!";
        //Act
        String actual = candy.getPhrase();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName_returns_name(){
        //Arrange
        String expected = "test";
        //Act
        String actual = candy.getName();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice_returns_price(){
        //Arrange
        BigDecimal expected = BigDecimal.valueOf(1.05);
        //Act
        BigDecimal actual = candy.getPrice();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getQuantity_returns_quantity(){
        //Arrange
        int expected = 5;
        //Act
        int actual = candy.getQuantity();
        //Assert
        Assert.assertEquals(expected, actual);
    }
}
