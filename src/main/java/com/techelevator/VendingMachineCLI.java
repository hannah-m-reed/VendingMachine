package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public static void main(String[] args) throws FileNotFoundException {
		Item item = new Item();
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		VendingMachine vendingMachine = new VendingMachine();
		Item item = new Item();
		  //===== you nay use/modify the existing Menu class or write your own ======
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
				System.out.println(Arrays.toString(item.getItemMap().get("A1")));
				System.out.println(item.getItemMap().get("A1")[1]);

			} else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}

	}

}
