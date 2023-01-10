package Machine;

public class ItemSelf {
	Item item;
	int code;
	boolean isSoldOut;
	
	public Item getItem() {
		return item;
	}
	public int getCode() {
		return code;
	}
	public boolean isSoldOut() {
		return isSoldOut;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public void setSoldOut(boolean isSoldOut) {
		this.isSoldOut = isSoldOut;
	}
	
	
}
