package Machine;

import VendingState.State;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vendingMachine=new VendingMachine();
		try {
			System.out.println("|");
            System.out.println("filling up the inventory");
            System.out.println("|");
            
            fillupInventory(vendingMachine);
            displayInventory(vendingMachine);
            
            System.out.println("|");
            System.out.println("clicking on InsertCoinButton");
            System.out.println("|");
            
            State vendingState = vendingMachine.getState();
            vendingState.clickOnInsertCoinButton(vendingMachine);

            vendingState = vendingMachine.getState();
            vendingState.insertCoin(vendingMachine, Coin.NICKEL);
            vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            
            System.out.println("|");
            System.out.println("clicking on ProductSelectionButton");
            System.out.println("|");
            vendingState.clickOnStartProductSelectionButton(vendingMachine);

            vendingState = vendingMachine.getState();
            vendingState.chooseProduct(vendingMachine, 102);

            displayInventory(vendingMachine);

            
		}catch(Exception e) {
			displayInventory(vendingMachine);
		}
	}

	private static void displayInventory(VendingMachine vendingMachine) {
		ItemSelf self[]=vendingMachine.inventory.self;
		for(int i=0;i<self.length;i++) {
			System.out.println("Name "+self[i].item.getItemType().name());
			System.out.println("Price "+self[i].item.price);
			System.out.println("Code "+self[i].code);
			System.out.println("IsSoldOut "+self[i].isSoldOut);
			System.out.println("=====================");
		}
	}

	private static void fillupInventory(VendingMachine vendingMachine) {
		ItemSelf slots[]=vendingMachine.inventory.self;
		for(int i=0;i<slots.length;i++) {
			Item item=new Item();
			if(i<5) {
				item.setItemType(ItemType.COKE);
				item.price=20;
			}if(i>=5 && i<10) {
				item.setItemType(ItemType.JUICE);
				item.price=30;
			}if(i>=10 && i<15) {
				item.setItemType(ItemType.PEPSI);
				item.price=22;
			}if(i>=15 && i<20) {
				item.setItemType(ItemType.SODA);
				item.price=12;
			}
			
			slots[i].item=item;
			slots[i].isSoldOut=false;
		}
	}

}
