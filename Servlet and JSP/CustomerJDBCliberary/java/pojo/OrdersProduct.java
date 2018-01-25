package pojo;

public class OrdersProduct {

	private int order_product_ID_PK;
	private int order_ID_FK;
	private int product_ID_FK;
	private int quantity;
	public int getOrder_product_ID_PK() {
		return order_product_ID_PK;
	}
	public void setOrder_product_ID_PK(int order_product_ID_PK) {
		this.order_product_ID_PK = order_product_ID_PK;
	}
	public int getOrder_ID_FK() {
		return order_ID_FK;
	}
	public void setOrder_ID_FK(int order_ID_FK) {
		this.order_ID_FK = order_ID_FK;
	}
	public int getProduct_ID_FK() {
		return product_ID_FK;
	}
	public void setProduct_ID_FK(int product_ID_FK) {
		this.product_ID_FK = product_ID_FK;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
