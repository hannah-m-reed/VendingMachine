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

    private void setLists(){
        try(Scanner inputStream = new Scanner(fileInput)){
            while(inputStream.hasNextLine()){
                fileContents.add(inputStream.nextLine());
            }
            for(int i = 0; i < fileContents.size(); i++){
                itemList[i] = fileContents.get(i).split("\\|");
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
    }

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

