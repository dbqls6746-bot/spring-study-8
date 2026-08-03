package com.app.dto.study.request;

public class ProductRequestForm {
	
	public String id;
	public String name;
	public int price;
	
	String type;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ProductRequestForm [id=" + id + ", name=" + name + ", price=" + price + ", type=" + type
				+ ", getType()=" + getType() + ", getId()=" + getId() + ", getName()=" + getName() + ", getPrice()="
				+ getPrice() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
