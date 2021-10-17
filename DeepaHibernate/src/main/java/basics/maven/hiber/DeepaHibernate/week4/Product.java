package basics.maven.hiber.DeepaHibernate.week4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
public class Product 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	private String name;
	private String tech;
	private String client;
	
	public Product(String name, String tech, String client) {
		super();
		this.name = name;
		this.tech = tech;
		this.client = client;
	}
	
	@ManyToMany(mappedBy = "career")
	private Collection<ResourcePerson> persons=new ArrayList<ResourcePerson>();
	public Collection<ResourcePerson> getPersons() {
		return persons;
	}
	public void setPersons(Collection<ResourcePerson> persons) {
		this.persons = persons;
	}
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", tech=" + tech + ", client=" + client + ", persons="
				+ persons + "]";
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String tech, String client, Collection<ResourcePerson> persons) {
		super();
		this.name = name;
		this.tech = tech;
		this.client = client;
		this.persons = persons;
	}
	/*
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	private ResourcePerson person;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String name, String tech, String client, ResourcePerson person) {
		super();
		this.name = name;
		this.tech = tech;
		this.client = client;
		this.person = person;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", name=" + name + ", tech=" + tech + ", client=" + client + ", person=" + person
				+ "]";
	}
	public ResourcePerson getPerson() {
		return person;
	}
	public void setPerson(ResourcePerson person) {
		this.person = person;
	}
	*/
	
	
	
	
	/*
	 * public Product() { super(); // TODO Auto-generated constructor stub } public
	 * Product(String name, String tech, String client) { super(); this.name = name;
	 * this.tech = tech; this.client = client; }
	 * 
	 * @Override public String toString() { return "Product [pid=" + pid + ", name="
	 * + name + ", tech=" + tech + ", client=" + client + "]"; }
	 */
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTech() {
		return tech;
	}
	public void setTech(String tech) {
		this.tech = tech;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
}
