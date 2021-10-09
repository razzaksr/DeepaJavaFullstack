package basics.maven.hiber.DeepaHibernate.week3;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Goods 
{
	private String name;
	private String brand;
	@Temporal(TemporalType.DATE)
	private Date manufact;
	private int qty;
	private int price;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	
	@Embedded
	@AttributeOverrides(
	{
		@AttributeOverride(name = "items",column =@Column(name="grade1_items")),
		@AttributeOverride(name = "levels",column =@Column(name="grade1_levels")),
		@AttributeOverride(name = "process",column =@Column(name="grade1_makings"))
	})
	private Stuffs stuff;
	
	@Embedded
	private Stuffs stuffing;
	
	public Stuffs getStuffing() {
		return stuffing;
	}
	public void setStuffing(Stuffs stuffing) {
		this.stuffing = stuffing;
	}
	@Override
	public String toString() {
		return "Goods [name=" + name + ", brand=" + brand + ", manufact=" + manufact + ", qty=" + qty + ", price="
				+ price + ", number=" + number + ", stuff=" + stuff + "]";
	}
	public Goods() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Goods(String name, String brand, Date manufact, int qty, int price,  Stuffs stuff) {
		super();
		this.name = name;
		this.brand = brand;
		this.manufact = manufact;
		this.qty = qty;
		this.price = price;
		this.stuff = stuff;
	}
	public Stuffs getStuff() {
		return stuff;
	}
	public void setStuff(Stuffs stuff) {
		this.stuff = stuff;
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
