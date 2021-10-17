package basics.maven.hiber.DeepaHibernate.week4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


@Entity
public class Furniture {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int ItemNo;
private String ItemName;
private int price;
@ElementCollection(fetch = FetchType.EAGER)
@GenericGenerator(name="Deepa",strategy =  "increment")
@CollectionId(columns = { @Column(name="ITid") }, generator = "Deepa", type = @Type(type = "long"))
///@CollectionId(columns = {@Column(name="StuffsID")},generator = "zealgen",type = @Type(type = "long"))
private Collection<FurnitureQuality> Fq=new ArrayList<FurnitureQuality>();
public Furniture() {
	super();
	// TODO Auto-generated constructor stub
}
public Furniture(String itemName, int price) {
	super();
	ItemName = itemName;
	this.price = price;
}
public Collection<FurnitureQuality> getFq() {
	return Fq;
}
public void setFq(Collection<FurnitureQuality> fq) {
	Fq = fq;
}
@Override
public String toString() {
	return "Furniture [ItemNo=" + ItemNo + ", ItemName=" + ItemName + ", price=" + price + "]";
}
public int getItemNo() {
	return ItemNo;
}
public void setItemNo(int itemNo) {
	ItemNo = itemNo;
}
public String getItemName() {
	return ItemName;
}
public void setItemName(String itemName) {
	ItemName = itemName;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
}
