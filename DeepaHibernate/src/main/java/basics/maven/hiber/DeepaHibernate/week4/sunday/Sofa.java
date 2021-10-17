package basics.maven.hiber.DeepaHibernate.week4.sunday;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Sofa 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stocknum;
	private String brand;
	private String type;
	private int size;
	private int price;
	private String material;
	public Sofa() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Sofa(String brand, String type, int size, int price, String material) {
		super();
		this.brand = brand;
		this.type = type;
		this.size = size;
		this.price = price;
		this.material = material;
	}
	@Override
	public String toString() {
		return "Sofa [stocknum=" + stocknum + ", brand=" + brand + ", type=" + type + ", size=" + size + ", price="
				+ price + ", material=" + material + "]";
	}
	public int getStocknum() {
		return stocknum;
	}
	public void setStocknum(int stocknum) {
		this.stocknum = stocknum;
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
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
}
