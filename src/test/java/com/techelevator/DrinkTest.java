package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DrinkTest {
    private Drink drink;

    @Before
    public void setup(){
        drink = new Drink("test", BigDecimal.valueOf(1.80));
    }

    @After
    public void teardown(){

    }
    @Test
    public void getPhrase_returns_phrase(){
        //Arrange
        String expected = "Glug Glug, Yum!";
        //Act
        String actual = drink.getPhrase();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName_returns_name(){
        //Arrange
        String expected = "test";
        //Act
        String actual = drink.getName();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice_returns_price(){
        //Arrange
        BigDecimal expected = BigDecimal.valueOf(1.80);
        //Act
        BigDecimal actual = drink.getPrice();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getQuantity_returns_quantity(){
        //Arrange
        int expected = 5;
        //Act
        int actual = drink.getQuantity();
        //Assert
        Assert.assertEquals(expected, actual);
    }
}
