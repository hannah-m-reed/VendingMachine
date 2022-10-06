package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VendingMachine {
    private ChangeSorter changeSorter;
    private List<String> fileContents = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private String[][] itemList = new String[fileContents.size()][4];
    private File fileInput = new File("vendingmachine.csv");

    public VendingMachine() {
        this.changeSorter = new ChangeSorter();

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
