package Machine;

public class Inventory {
	
	ItemSelf self[]=null;
	Inventory(int size){
		this.self=new ItemSelf[size];
		initialEmptyInventory();
	}
	public ItemSelf[] getInventory() {
        return self;
    }

    public void setInventory(ItemSelf[] inventory) {
        this.self = inventory;
    }

    public void initialEmptyInventory() {
        int startCode = 101;
        for (int i = 0; i < self.length; i++) {
        	ItemSelf space = new ItemSelf();
            space.setCode(startCode);
            space.setSoldOut(false);
            self[i]= space;
            startCode++;
        }
    }
    
    public void addItem(Item item, int codeNumber) throws Exception {

        for (ItemSelf itemShelf : self) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    itemShelf.item = item;
                    itemShelf.setSoldOut(false);
                } else {
                    throw new Exception("already item is present, you can not add item here");
                }
            }
        }
    }

    public Item getItem(int codeNumber) throws Exception {

        for (ItemSelf itemShelf : self) {
            if (itemShelf.code == codeNumber) {
                if (itemShelf.isSoldOut()) {
                    throw new Exception("item already sold out");
                } else {

                    return itemShelf.item;
                }
            }
        }
        throw new Exception("Invalid Code");
    }

    public void updateSoldOutItem(int codeNumber){
        for (ItemSelf itemShelf : self) {
            if (itemShelf.code == codeNumber) {
                itemShelf.setSoldOut(true);
            }
        }
    }

    
    

}
