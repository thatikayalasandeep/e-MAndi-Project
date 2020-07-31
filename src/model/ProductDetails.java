package model;

public class ProductDetails {
private int product_ID;
private String productname;
private float cost;
private long quantity;
public ProductDetails(int product_ID, String productname, float cost, long quantity) {
	this.product_ID = product_ID;
	this.productname = productname;
	this.cost = cost;
	this.quantity = quantity;
}
public int getProduct_ID() {
	return product_ID;
}
public void setProduct_ID(int product_ID) {
	this.product_ID = product_ID;
}
public String getProductname() {
	return productname;
}
public void setProductname(String productname) {
	this.productname = productname;
}
public float getCost() {
	return cost;
}
public void setCost(float cost) {
	this.cost = cost;
}
public long getQuantity() {
	return quantity;
}
public void setQuantity(long quantity) {
	this.quantity = quantity;
}



}
