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
			//If 1 is selected:
			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				//Display itemList array to console
				displayMenuItems();
			//If 2 is selected:
			}else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				while(true) {
					//Update Current Money Provided display in Purchase Menu
					updateCurrentMoney();
					//Setting choice from Purchase Menu
					String choice2 = (String) menu.getChoiceFromOptions(PURCHASE_MENU_OPTIONS, currentMoney);
					//If 1 selected: feed money prompt appears
					if (choice2.equals(PURCHASE_MENU_FEED_MONEY)) {
						//Try user input to enter money
						try {
							//Create log of user choice and call customerMoneyInput method
							vendingMachine.createLogFile("FEED MONEY: ", customerMoneyInput());
						//Catch if input is not proper format or type
						}catch(NumberFormatException e){
							System.out.println();
							System.out.println("Please enter provided integers");
						}
						//If 2 is selected: product selection appears with quantities available
					} else if (choice2.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
						//Display menu items
						displayMenuItems();
						//Take in case-insensitive user input and return product phrase if available, else prompt customer
						customerChoice();
						//If 3 is selected: user change is returned and user is returned to the main menu
					} else if (choice2.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
						//Create log file of change return and call method
						vendingMachine.createLogFile("GIVE CHANGE: ", vendingMachine.moneyBox.changeReturn());
						//return to main menu
						break;
					}
				}
				//If 3 selected: exit program
			} else if (choice.equals(MAIN_MENU_EXIT)) {
				//Terminate vending machine program
				System.exit(0);
				//If 4 selected: generate sales report before exiting program
			} else if (choice.equals(MAIN_MENU_SALES_REPORT)) {
				//Generate sales report
				vendingMachine.generateSalesReceipt();
				//Terminate vending machine program
				System.exit(0);
			}
		}
	}

	//Method prompting user for payment and calling feedMoney method in MoneyBox class
	public BigDecimal customerMoneyInput(){
		//Declare BigDecimal variable
		BigDecimal customerInput;
			//Prompt user for input
			System.out.print("How much money would you like to put in? (1, 5, 10): ");
			//Instantiate customerInput variable
			customerInput = BigDecimal.valueOf(Integer.parseInt(input.nextLine()));
			//If feedMoney returns true, continue
			if (vendingMachine.moneyBox.feedMoney(customerInput)) {
				//this is empty
			//Else prompt user to input correct amount on next iteration
			}else{
				System.out.println();
				System.out.println("Please enter 1, 5, or 10");
			}
		return customerInput;
	}

	//Method for getting the most up-to-date money
	public void updateCurrentMoney(){
		//Declaring and instantiating temporary BigDecimal variable to reassign (BidDecimal is immutable)
		BigDecimal result = vendingMachine.moneyBox.getCurrentMoney();
		//Reassign currentMoney in CLI class
		currentMoney = result;
	}

	//Method takes itemList array and displays in a readable format for the user
	public void displayMenuItems(){
		//Cycling through each array in itemList and printing each element in order
		for (int i = 0; i < vendingMachine.vendingInventory.getFileContents().size(); i++) {
			String list = "";
			for (int k = 0; k < 3; k++) {
				list += vendingMachine.vendingInventory.getItemList()[i][k] + " ";
			}
			//Check if item is in stock; if so, print current quantity from this vendingMachineContents arraylist
			if(vendingMachine.vendingInventory.getItems().get(i).getQuantity() > 0) {
				System.out.println(list + "Quantity: " + vendingMachine.vendingInventory.getItems().get(i).getQuantity());
			//If item is sold out, print **SOLD OUT** to console
			} else if (vendingMachine.vendingInventory.getItems().get(i).getQuantity() <= 0) {
				System.out.println(list + " **SOLD OUT**");
			}
		}
	}
	//Method for getting customer input on Product Selection and determining validity of request
	public void customerChoice(){
		System.out.println();
		//Prompt user for input
		System.out.print("Please enter a choice: ");
		//Read case-insensitive user input
		String customerChoice = input.nextLine().toUpperCase();
		System.out.println();
		//Sting variable holding all possible customer choices for comparison
		String choices = "";
		//Create list of possible choices for comparison against customer choice
		for(int i = 0; i < vendingMachine.vendingInventory.getItemList().length; i++) {
			choices += (vendingMachine.vendingInventory.getItemList()[i][0]) + " ";
		}
		//Iterate through choices until one matching customer input is found with feedback
		for(int i = 0; i < vendingMachine.vendingInventory.getItemList().length; i++) {
			//Compare customer choice to possible choices to alert customer to improper selection
			if (choices.contains(customerChoice)) {
				//Actual checking of customer choice
				if (customerChoice.equals(vendingMachine.vendingInventory.getItemList()[i][0])) {
					//After valid selection made check if item is in stock && if customer has funds
					if (vendingMachine.vendingInventory.getItems().get(i).getQuantity() > 0 && vendingMachine.moneyBox.makePurchase(vendingMachine.vendingInventory.getItems().get(i).getPrice())) {
						//Decrement item quantity
						vendingMachine.vendingInventory.getItems().get(i).setQuantity();
						//Create log file for sale
						vendingMachine.createLogFile(vendingMachine.vendingInventory.getItems().get(i).getName() + " " + vendingMachine.vendingInventory.getItemList()[i][0], vendingMachine.vendingInventory.getItems().get(i).getPrice());
						//Print item phrase
						System.out.println(vendingMachine.vendingInventory.getItems().get(i).getPhrase());
					}else if(vendingMachine.vendingInventory.getItems().get(i).getQuantity() <= 0){
						System.out.println("Item sold out");
					}
				}
			} else {
				System.out.println("Item does not exist");
				break;
			}
		}
	}
}
