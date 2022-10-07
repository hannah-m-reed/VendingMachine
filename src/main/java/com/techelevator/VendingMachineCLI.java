package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.Scanner;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };
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


		  //===== you nay use/modify the existing Menu class or write your own ======
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				displayMenuItems();
			}else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					updateCurrentMoney();
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, currentMoney);
					BigDecimal currentMoney = vendingMachine.moneyBox.getCurrentMoney();
					//System.out.println("Current Money Provided: $" + currentMoney);
					if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						customerMoneyInput();
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						displayMenuItems();
						customerChoice();
					} else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						vendingMachine.moneyBox.resetCurrentMoney();
						updateCurrentMoney();
						break;}
				}
			}
		}
	}
	public void customerMoneyInput(){
		String continueInput = "Y";
		while(continueInput.equals("Y")) {
			System.out.print("How much money would you like to put in? (1, 5, 10): ");
			BigDecimal customerInput = BigDecimal.valueOf(Integer.parseInt(input.nextLine()));
			if (vendingMachine.moneyBox.feedMoney(customerInput)) {

			} else {
				System.out.println("Please enter valid amount");
			}
			System.out.print("Would you like to continue adding money? (Y/N): ");
			continueInput = input.nextLine();
		}
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
		System.out.print("Please enter a choice: ");
		String customerChoice = input.nextLine();
		String choices = "";
		for(int i = 0; i < vendingMachine.vendingInventory.getItemList().length; i++) {
			choices += vendingMachine.vendingInventory.getItemList()[i][0];
		}
		for(int i = 0; i < vendingMachine.vendingInventory.getItemList().length; i++) {
			if (choices.contains(customerChoice)) {
				if (customerChoice.equals(vendingMachine.vendingInventory.getItemList()[i][0])) {
					if (vendingMachine.moneyBox.getCurrentMoney().compareTo(vendingMachine.vendingInventory.getItems().get(i).getPrice()) >= 0) {
						//decrement quantity
						if (vendingMachine.vendingInventory.getItems().get(i).setQuantity()) {
							//update balance
							if (vendingMachine.moneyBox.setCurrentMoney(vendingMachine.vendingInventory.getItems().get(i).getPrice())) {
								//print phrase
								System.out.println(vendingMachine.vendingInventory.getItems().get(i).getPhrase());
							}
						}
					}else{
						System.out.println();
						System.out.println("Insufficient funds"); //noting for later
					}
				}
			}else{
				System.out.println("Item does not exist");
				break;
			}
		}
	}
}
