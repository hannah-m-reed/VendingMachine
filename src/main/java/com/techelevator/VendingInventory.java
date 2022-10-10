package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingInventory {

    private List<String> fileContents = new ArrayList<>();
    private List<Item> vendingMachineContents = new ArrayList<>();
    private String[][] itemList = new String[16][4];
    private File fileInput = new File("vendingmachine.csv");

    //VendingInventory constructor calls setList to make a list of items from vendingmachine.csv and calls a method that stocks inventory from that list
    public VendingInventory(){
        setLists();
        stockInventory();
    }
    public List<String> getFileContents() {
        return fileContents;
    }

    public String[][] getItemList() {
        return itemList;
    }

    //Method creates an arraylist and multidimensional array from input file
    private void setLists(){
        try(Scanner inputStream = new Scanner(fileInput)){
            while(inputStream.hasNextLine()){
                fileContents.add(inputStream.nextLine());
            }
            //array split on |(pipe) character in file
            for(int i = 0; i < fileContents.size(); i++){
                itemList[i] = fileContents.get(i).split("\\|");
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
    }

    //Method stocks an arraylist of Items for use in CLI
    private void stockInventory(){
        for(int i = 0; i < itemList.length; i++) {
            if (itemList[i][3].equals("Candy")) {
                vendingMachineContents.add(new Candy(itemList[i][1], BigDecimal.valueOf(Double.parseDouble(itemList[i][2]))));
            } else if (itemList[i][3].equals("Chip")) {
                vendingMachineContents.add(new Chip(itemList[i][1], BigDecimal.valueOf(Double.parseDouble(itemList[i][2]))));
            } else if (itemList[i][3].equals("Drink")) {
                vendingMachineContents.add(new Drink(itemList[i][1], BigDecimal.valueOf(Double.parseDouble(itemList[i][2]))));
            } else if (itemList[i][3].equals("Gum")) {
                vendingMachineContents.add(new Gum(itemList[i][1], BigDecimal.valueOf(Double.parseDouble(itemList[i][2]))));
            }
        }
    }

    public List<Item> getItems(){
        return this.vendingMachineContents;
    }
}

