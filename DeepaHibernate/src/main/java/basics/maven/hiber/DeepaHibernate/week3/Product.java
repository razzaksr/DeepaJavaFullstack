package basics.maven.hiber.DeepaHibernate.week3;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Product 
{
	private String name;
	@Transient
	private String brand;
	@Temporal(TemporalType.DATE)
	private Date manufact;
	@Column(insertable = false)
	private int qty;
	private int price;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String brand, Date manufact, int qty, int price) {
		super();
		this.name = name;
		this.brand = brand;
		this.manufact = manufact;
		this.qty = qty;
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", brand=" + brand + ", manufact=" + manufact + ", qty=" + qty + ", price="
				+ price + ", number=" + number + "]";
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Date getManufact() {
		return manufact;
	}
	public void setManufact(Date manufact) {
		this.manufact = manufact;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
