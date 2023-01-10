package Machine;

import java.util.ArrayList;
import java.util.List;

import VendingState.IdleState;
import VendingState.State;


public class VendingMachine {
	
	State state;
	Inventory inventory;
	List<Coin> list;
	
	VendingMachine(){
		this.state=new IdleState();
		this.inventory=new Inventory(10);
		this.list=new ArrayList<>();
	}

	public State getState() {
		return state;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public List<Coin> getList() {
		return list;
	}

	public void setState(State state) {
		this.state = state;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public void setList(List<Coin> list) {
		this.list = list;
	}
	

}
