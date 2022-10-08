package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GumTest {
    private Gum gum;

    @Before
    public void setup(){
        gum = new Gum("test", BigDecimal.valueOf(.85));
    }

    @After
    public void teardown(){

    }
    @Test
    public void getPhrase_returns_phrase(){
        //Arrange
        String expected = "Chew Chew, Yum!";
        //Act
        String actual = gum.getPhrase();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName_returns_name(){
        //Arrange
        String expected = "test";
        //Act
        String actual = gum.getName();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice_returns_price(){
        //Arrange
        BigDecimal expected = BigDecimal.valueOf(.85);
        //Act
        BigDecimal actual = gum.getPrice();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getQuantity_returns_quantity(){
        //Arrange
        int expected = 5;
        //Act
        int actual = gum.getQuantity();
        //Assert
        Assert.assertEquals(expected, actual);
    }
}
