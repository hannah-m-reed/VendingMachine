package com.techelevator;

import com.techelevator.view.Menu;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;

import static java.lang.Integer.parseInt;

public class VendingMachineCLI {

	private static final String MAIN_MENU_OPTION_DISPLAY_ITEMS = "Display Vending Machine Items";
	private static final String MAIN_MENU_OPTION_PURCHASE = "Purchase";
	private static final String[] MAIN_MENU_OPTIONS = { MAIN_MENU_OPTION_DISPLAY_ITEMS, MAIN_MENU_OPTION_PURCHASE };

	private Menu menu;

	public static void main(String[] args) throws FileNotFoundException {
		Menu menu = new Menu(System.in, System.out);
		VendingMachineCLI cli = new VendingMachineCLI(menu);
		cli.run();
	}

	public VendingMachineCLI(Menu menu) {
		this.menu = menu;
	}

	public void run() {

		VendingMachine vendingMachine = new VendingMachine();
		  //===== you nay use/modify the existing Menu class or write your own ======
		while (true) {
			String choice = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

			if (choice.equals(MAIN_MENU_OPTION_DISPLAY_ITEMS)) {
//				for(Map.Entry<String, String[]> element: item.getItemMap().entrySet()){
//					System.out.printf("%s %s %s %s", element.getKey(), element.getValue()[1], element.getValue()[2], element.getValue()[4] + "\n");
//				}
				for (int i = 0; i < vendingMachine.vendingInventory.getFileContents().size(); i++) {
					String list = "";
					//System.out.println(vendingMachine.getFileContents().get(i));
					for (int k = 0; k < 3; k++) {
						list += vendingMachine.vendingInventory.getItemList()[i][k] + " ";
					}
					System.out.println(list + "Quantity: " + vendingMachine.vendingInventory.getItems().get(i).getQuantity());

				}
				for(Item item: vendingMachine.vendingInventory.getItems()){
					System.out.println(item.toString());
				}
			}else if (choice.equals(MAIN_MENU_OPTION_PURCHASE)) {
				// do purchase
			}
		}

	}

}
