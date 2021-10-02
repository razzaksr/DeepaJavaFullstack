package basics.maven.hiber.DeepaHibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pen 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stockId;
	private String model;
	private String brand;
	private String color;
	private int cost;
	private int qty;
	public Pen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Pen(int stockId, String model, String brand, String color, int cost, int qty) {
		super();
		this.stockId = stockId;
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.cost = cost;
		this.qty = qty;
	}
	public Pen(String model, String brand, String color, int cost, int qty) {
		super();
		this.model = model;
		this.brand = brand;
		this.color = color;
		this.cost = cost;
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "Pen [stockId=" + stockId + ", model=" + model + ", brand=" + brand + ", color=" + color + ", cost="
				+ cost + ", qty=" + qty + "]";
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
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
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
}
