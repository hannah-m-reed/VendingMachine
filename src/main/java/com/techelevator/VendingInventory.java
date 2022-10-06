package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingInventory{
    private List<String> inventory = new ArrayList<>();
    private Map<String, Integer> inventoryQuantities = new HashMap<>();
    File inventoryFile = new File("vendingmachine.csv");



    public VendingInventory(){
        try(Scanner fileScanner = new Scanner(inventoryFile)){
            if(inventoryFile.exists()){
                while(fileScanner.hasNextLine()){
                    inventory.add(fileScanner.nextLine());
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
        setInventory();
    }
    public String[][] getInventory(){
        String[][] item = new String[16][4];
        for (int i = 0; i < inventory.size(); i++) {
            item[i] = inventory.get(i).split("\\|");
        }
        return item;
    }
    private void setInventory(){
        for(String[] item: getInventory()){
            inventoryQuantities.put(item[0], 5);
        }
    }
}
