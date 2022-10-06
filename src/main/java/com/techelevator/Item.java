package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Item extends VendingInventory{

    private List<String> inventory = new ArrayList<>();
    private File inventoryFile = new File("vendingmachine.csv");
    private Map<String, String[]> itemMap = new HashMap<>();
    private String[][] item = new String[16][4];


    private void inventorySetup(){
        try(Scanner fileScanner = new Scanner(inventoryFile)){
            if(inventoryFile.exists()){
                while(fileScanner.hasNextLine()){
                    inventory.add(fileScanner.nextLine());
                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
    }

    public Item(){
        String[] strings = new String[4];
        inventorySetup();
        for (int i = 0; i < inventory.size(); i++) {
            String[] swap = new String[5];
            String[] swap2 = inventory.get(i).split("\\|");
            for (int j = 0; j < 4; j++) {
                swap[j] = swap2[j];
            }
            swap[4] = "5";
            item[i] = swap;
            itemMap.put(item[i][0], item[i]);
        }
    }

    public Map<String, String[]> getItemMap(){
        return itemMap;
    }

    public List<String> getInventory(){
        return inventory;
    }
    public String[][] getItem(){
        return this.item;
    }

    public Map<String, String[]> updateInventory(String key, int quantity){
        int remaining = parseInt(itemMap.get(key)[4]) - quantity;
        String[] replace = itemMap.get(key);
        replace[4] = "" + remaining;
        itemMap.put(key, replace);
        return itemMap;
    }

}
