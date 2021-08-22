package basics.deepa.java.DeepaJavaBasics.files;

import java.io.Serializable;

public class Car implements Serializable
{
	private String model;
	private String brand;
	private String type;
	private Double price;
	private Integer release;
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getRelease() {
		return release;
	}
	public void setRelease(Integer release) {
		this.release = release;
	}
	public Car(String model, String brand, String type, Double price, Integer release) {
		super();
		this.model = model;
		this.brand = brand;
		this.type = type;
		this.price = price;
		this.release = release;
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Car [model=" + model + ", brand=" + brand + ", type=" + type + ", price=" + price + ", release="
				+ release + "]";
	}
}
