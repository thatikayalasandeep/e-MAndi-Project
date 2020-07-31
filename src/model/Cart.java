package model;

public class Cart {

	private String itemname;
	private int quantity;
	private long buyerid;
	public Cart(String itemname, int quantity,long buyerid) {
		this.itemname = itemname;
		this.quantity = quantity;
		this.buyerid=buyerid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public long getBuyerid() {
		return buyerid;
	}
	public void setBuyerid(long buyerid) {
		this.buyerid = buyerid;
	}
	
	
}
