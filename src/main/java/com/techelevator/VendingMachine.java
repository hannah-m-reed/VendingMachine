package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class VendingMachine {
    private MoneyBox changeSorter;
    private List<String> fileContents = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private Map<String, String[]> vendingOptions = new HashMap<>();
    private String[][] itemList = new String[16][4];
    private File fileInput = new File("vendingmachine.csv");

    public VendingMachine() {
        this.changeSorter = new MoneyBox();
        this.machineSetup();
    }
    private void machineSetup(){
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

    public List<String> getFileContents() {
        return fileContents;
    }

    public String[][] getItemList() {
        return itemList;
    }
}
