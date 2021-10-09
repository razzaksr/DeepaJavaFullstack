package basics.maven.hiber.DeepaHibernate.week3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.ElementCollection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
public class Stocks 
{
	private String name;
	private String brand;
	@Temporal(TemporalType.DATE)
	private Date manufact;
	private int qty;
	private int price;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;
	
	@ElementCollection
	@JoinTable(name="StockItems",joinColumns=@JoinColumn(name="StockId"))
	@GenericGenerator(name="zealgen",strategy = "sequence")
	@CollectionId(columns = {@Column(name="StuffsID")},generator = "zealgen",type = @Type(type = "long"))
	private Collection<Stuffs> many=new ArrayList<Stuffs>();
	
	public Stocks(String name, String brand, Date manufact, int qty, int price, int number, Collection<Stuffs> many) {
		super();
		this.name = name;
		this.brand = brand;
		this.manufact = manufact;
		this.qty = qty;
		this.price = price;
		this.number = number;
		this.many = many;
	}
	@Override
	public String toString() {
		return "Stocks [name=" + name + ", brand=" + brand + ", manufact=" + manufact + ", qty=" + qty + ", price="
				+ price + ", number=" + number + ", many=" + many + "]";
	}
	public Collection<Stuffs> getMany() {
		return many;
	}
	public void setMany(Collection<Stuffs> many) {
		this.many = many;
	}
	public Stocks() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stocks(String name, String brand, Date manufact, int qty, int price) {
		super();
		this.name = name;
		this.brand = brand;
		this.manufact = manufact;
		this.qty = qty;
		this.price = price;
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
