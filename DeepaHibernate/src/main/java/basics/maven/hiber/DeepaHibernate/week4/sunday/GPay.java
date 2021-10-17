package basics.maven.hiber.DeepaHibernate.week4.sunday;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("Wallet")
public class GPay extends Google
{
	private long accnumber;
	private double accbalance;
	
	public void send(int amt)
	{
		if(amt<=accbalance)
		{
			accbalance-=amt;
			System.out.println(amt+" send successfully");
		}
		else {
			System.out.println("Insufficient");
		}
	}
	
	public GPay(long accnumber, double accbalance) {
		super();
		this.accnumber = accnumber;
		this.accbalance = accbalance;
	}
	public GPay() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GPay(String email, String username, Date dob) {
		super(email, username, dob);
		//setEmail(email);
		//setUsername(username);
		//setDob(dob);
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "GPay [accnumber=" + accnumber + ", accbalance=" + accbalance + "]";
	}
	public long getAccnumber() {
		return accnumber;
	}
	public void setAccnumber(long accnumber) {
		this.accnumber = accnumber;
	}
	public double getAccbalance() {
		return accbalance;
	}
	public void setAccbalance(double accbalance) {
		this.accbalance = accbalance;
	}
}
