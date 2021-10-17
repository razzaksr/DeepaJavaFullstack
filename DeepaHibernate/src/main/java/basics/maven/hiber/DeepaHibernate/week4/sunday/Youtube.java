package basics.maven.hiber.DeepaHibernate.week4.sunday;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("VideosApp")
public class Youtube extends Google 
{
	private String[] uploads;
	private String[] watchlater;
	@Override
	public String toString() {
		return "Youtube [uploads=" + Arrays.toString(uploads) + ", watchlater=" + Arrays.toString(watchlater) + "]";
	}
	public Youtube() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Youtube(String email, String username, Date dob) {
		super(email, username, dob);
		// TODO Auto-generated constructor stub
		//setEmail(email);
		//setUsername(username);
		//setDob(dob);
	}
	public Youtube(String[] uploads, String[] watchlater) {
		super();
		this.uploads = uploads;
		this.watchlater = watchlater;
	}
	public String[] getUploads() {
		return uploads;
	}
	public void setUploads(String[] uploads) {
		this.uploads = uploads;
	}
	public String[] getWatchlater() {
		return watchlater;
	}
	public void setWatchlater(String[] watchlater) {
		this.watchlater = watchlater;
	}
}
