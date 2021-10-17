package basics.maven.hiber.DeepaHibernate.week4;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Embeddable
public class FurnitureQuality {

	private String NumberItem;
	private String ItemDesc;
	@Temporal(TemporalType.DATE)
	private Date ManuDate;

	public FurnitureQuality() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FurnitureQuality(String numberItem, String itemDesc, Date manuDate) {
		super();
		NumberItem = numberItem;
		ItemDesc = itemDesc;
		ManuDate = manuDate;
	}
	public String getNumberItem() {
		return NumberItem;
	}
	public void setNumberItem(String numberItem) {
		NumberItem = numberItem;
	}
	public String getItemDesc() {
		return ItemDesc;
	}
	public void setItemDesc(String itemDesc) {
		ItemDesc = itemDesc;
	}
	public Date getManuDate() {
		return ManuDate;
	}
	public void setManuDate(Date manuDate) {
		ManuDate = manuDate;
	}
	
	
}
