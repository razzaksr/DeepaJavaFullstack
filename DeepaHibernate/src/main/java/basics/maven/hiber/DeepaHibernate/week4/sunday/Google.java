package basics.maven.hiber.DeepaHibernate.week4.sunday;

import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
//@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name = "App")
//@DiscriminatorValue("Email")
public class Google 
{
	@Id @GeneratedValue(strategy = GenerationType.AUTO)//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userid;
	private String email;
	private String username;
	@Temporal(TemporalType.DATE)
	private Date dob;
	@Override
	public String toString() {
		return "Google [userid=" + userid + ", email=" + email + ", username=" + username + ", dob=" + dob + "]";
	}
	public Google() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Google(String email, String username, Date dob) {
		super();
		this.email = email;
		this.username = username;
		this.dob = dob;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
}
