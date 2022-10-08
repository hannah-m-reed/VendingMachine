package com.techelevator;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.sql.PreparedStatement;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class VendingMachineTest {
    File log = new File("log.txt");
    File test = new File("TestFile.txt");
    private VendingMachine vendingMachine;

    @Before
    public void setup(){
        vendingMachine = new VendingMachine();
        try(PrintWriter dataOutput = new PrintWriter(log)){

        } catch (FileNotFoundException e){
            System.out.println("File not found");
        }
    }

    @After
    public void teardown(){

    }

//    @Test
//    public void testLogFileOutput(){
//        //Arrange
//        File expected = test;
//        //Act
//        vendingMachine.moneyBox.feedMoney(BigDecimal.valueOf(10));
//
//        File actual = vendingMachine.createLogFile();
//    }

}
