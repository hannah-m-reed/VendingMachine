package com.techelevator;

import org.junit.*;
import org.junit.runners.MethodSorters;

import java.math.BigDecimal;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ChipTest {
    private Chip chip;

    @Before
    public void setup(){
        chip = new Chip("test", BigDecimal.valueOf(2.35));
    }

    @After
    public void teardown(){

    }
    @Test
    public void getPhrase_returns_phrase(){
        //Arrange
        String expected = "Crunch Crunch, Yum!";
        //Act
        String actual = chip.getPhrase();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getName_returns_name(){
        //Arrange
        String expected = "test";
        //Act
        String actual = chip.getName();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPrice_returns_price(){
        //Arrange
        BigDecimal expected = BigDecimal.valueOf(2.35);
        //Act
        BigDecimal actual = chip.getPrice();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getQuantity_returns_quantity(){
        //Arrange
        int expected = 5;
        //Act
        int actual = chip.getQuantity();
        //Assert
        Assert.assertEquals(expected, actual);
    }
}
