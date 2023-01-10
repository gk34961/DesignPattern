package VendingState;

import java.util.List;

import Machine.Coin;
import Machine.Item;
import Machine.VendingMachine;

public class HasMoneyState implements State {

	public HasMoneyState() {
		System.out.println("Currently Vending machine is in HasMoneyState");
	}

	@Override
	public void clickOnInsertCoinButton(VendingMachine machine) throws Exception {
		return;
	}

	@Override
	public void clickOnStartProductSelectionButton(VendingMachine machine) throws Exception {
		machine.setState(new SelectionState());
	}

	@Override
	public void insertCoin(VendingMachine machine, Coin coin) throws Exception {
		System.out.println("Accepted the coin");
		machine.getList().add(coin);
	}

	@Override
	public void chooseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("you need to click on start product selection button first");
	}

	@Override
	public int getChange(int returnChangeMoney) throws Exception {
		throw new Exception("you can not get change in hasMoney state");
	}

	@Override
	public Item dispenseProduct(VendingMachine machine, int codeNumber) throws Exception {
		throw new Exception("product can not be dispensed in hasMoney state");
	}

	@Override
	public List<Coin> refundFullMoney(VendingMachine machine) throws Exception {
		System.out.println("Returned the full amount back in the Coin Dispense Tray");
		machine.setState(new IdleState(machine));
		return machine.getList();
	}

	@Override
	public void updateInventory(VendingMachine machine, Item item, int codeNumber) throws Exception {
		throw new Exception("you can not update inventory in hasMoney  state");
	}
}
