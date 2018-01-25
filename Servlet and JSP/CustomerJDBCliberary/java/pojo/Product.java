package pojo;

public class Product {

	private int product_ID_PK;
	private String name;
	private int description;
	private int price;
	
	public int getProduct_ID_PK() {
		return product_ID_PK;
	}
	public void setProduct_ID_PK(int product_ID_PK) {
		this.product_ID_PK = product_ID_PK;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDescription() {
		return description;
	}
	public void setDescription(int description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
