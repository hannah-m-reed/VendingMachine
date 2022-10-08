package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String MAIN_MENU_EXIT = "Exit";
	private static final String MAIN_MENU_SALES_REPORT = "Generate Sales Receipt";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE, MAIN_MENU_EXIT, MAIN_MENU_SALES_REPORT};
	private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
	private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
	private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
	private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY, PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

	private Menu menu;
	Scanner input = new Scanner(System.in);
	VendingMachine vendingMachine = new VendingMachine();
	BigDecimal currentMoney = vendingMachine.moneyBox.getCurrentMoney();

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayMenuItems();
			}else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					updateCurrentMoney();
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, currentMoney);
					if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						try {
							vendingMachine.createLogFile("FEED MONEY: ", customerMoneyInput());
						}catch(NumberFormatException e){
							System.out.println();
							System.out.println("Please enter provided integers");
						}
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						displayMenuItems();
						customerChoice();
					} else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						vendingMachine.createLogFile("GIVE CHANGE: ", vendingMachine.moneyBox.changeReturn());
						break;
					}
				}
			} else if (choice.equals(MAIN_MENU_EXIT)) {
				System.exit(0);
			} else if (choice.equals(MAIN_MENU_SALES_REPORT)) {
				vendingMachine.generateSalesReceipt();
				System.exit(0);
			}
		}
	}

	public BigDecimal customerMoneyInput(){
		BigDecimal customerInput;
			System.out.print("How much money would you like to put in? (1, 5, 10): ");
			customerInput = BigDecimal.valueOf(Integer.parseInt(input.nextLine()));
			if (vendingMachine.moneyBox.feedMoney(customerInput)) {
				//this is empty
			}else{
				System.out.println("Please enter a valid amount");
			}
		return customerInput;
	}

	public void updateCurrentMoney(){
		BigDecimal result = vendingMachine.moneyBox.getCurrentMoney();
		currentMoney = result;
	}

	public void displayMenuItems(){
		for (int i = 0; i < vendingMachine.vendingInventory.getFileContents().size(); i++) {
			String list = "";
			for (int k = 0; k < 3; k++) {
				list += vendingMachine.vendingInventory.getItemList()[i][k] + " ";
			}
			System.out.println(list + "Quantity: " + vendingMachine.vendingInventory.getItems().get(i).getQuantity());
		}
	}
	public void customerChoice(){
		System.out.println();
		System.out.print("Please enter a choice: ");
		String customerChoice = input.nextLine().toUpperCase();
		System.out.println();
		String choices = "";
		for(int i = 0; i < vendingMachine.vendingInventory.getItemList().length; i++) {
			choices += (vendingMachine.vendingInventory.getItemList()[i][0]) + " ";
		}
		for(int i = 0; i < vendingMachine.vendingInventory.getItemList().length; i++) {
			if (choices.contains(customerChoice)) {
				if (customerChoice.equals(vendingMachine.vendingInventory.getItemList()[i][0])) {
					if (vendingMachine.vendingInventory.getItems().get(i).setQuantity()) {
						if (vendingMachine.moneyBox.makePurchase(vendingMachine.vendingInventory.getItems().get(i).getPrice())) {
							vendingMachine.createLogFile(vendingMachine.vendingInventory.getItems().get(i).getName() + " " + vendingMachine.vendingInventory.getItemList()[i][0], vendingMachine.vendingInventory.getItems().get(i).getPrice());
							System.out.println(vendingMachine.vendingInventory.getItems().get(i).getPhrase());
						}
					}
				}
			} else {
				System.out.println("Item does not exist");
				break;
			}
		}
	}
}
