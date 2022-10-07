package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.*;

public class VendingInventory {

    private List<String> fileContents = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private Map<String, String[]> vendingOptions = new HashMap<>();
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

    public Map<String, String[]> getVendingOptions() {
        return vendingOptions;
    }
    private void setLists(){
        try(Scanner inputStream = new Scanner(fileInput)){
            while(inputStream.hasNextLine()){
                fileContents.add(inputStream.nextLine());
                //items.add(new Item());
            }
            for(int i = 0; i < fileContents.size(); i++){
                itemList[i] = fileContents.get(i).split("\\|");
                vendingOptions.put(fileContents.get(i).substring(0,2), fileContents.get(i).substring(3).split("\\|"));
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found " + e.getMessage());
        }
    }
    private void stockInventory(){
        for(Map.Entry<String, String[]> item: vendingOptions.entrySet()) {
            if (item.getValue()[2].equals("Candy")) {
                items.add(new Candy(item.getValue()[0], Double.parseDouble(item.getValue()[1])));
            } else if (item.getValue()[2].equals("Chip")) {
                items.add(new Chip(item.getValue()[0], Double.parseDouble(item.getValue()[1])));
            } else if (item.getValue()[2].equals("Drink")) {
                items.add(new Drink(item.getValue()[0], Double.parseDouble(item.getValue()[1])));
            } else if (item.getValue()[2].equals("Gum")) {
                items.add(new Gum(item.getValue()[0], Double.parseDouble(item.getValue()[1])));
            }
        }

    }

    public List<Item> getItems(){
        return this.items;
    }
}

