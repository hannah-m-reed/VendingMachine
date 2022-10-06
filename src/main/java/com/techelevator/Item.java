package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        inventorySetup();
        for (int i = 0; i < inventory.size(); i++) {
            String[] swap = new String[5];
            String[] swap2 = inventory.get(i).split("\\|");
            for (int j = 0; j < 4; j++) {
                swap[j] = swap2[j];
            }
            swap[4] = "5";
            item[i] = swap;
        }
        for(int i = 0; i < inventory.size(); i++){
            for(int k = 1; k < 4; k++){
                for ()
                itemMap.put(item[i][0], item[k]);
            }
        }

    }

    public Map<String, String[]> getItemMap(){
        return itemMap;
    }

    public List<String> getInventory(){

        return inventory;
    }

}
