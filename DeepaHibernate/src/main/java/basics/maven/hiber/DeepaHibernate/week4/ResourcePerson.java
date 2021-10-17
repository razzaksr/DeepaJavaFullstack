package basics.maven.hiber.DeepaHibernate.week4;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ResourcePerson 
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String skills;
	
	
	@ManyToMany
	@JoinTable(name="Info",joinColumns = @JoinColumn(name = "personId"),inverseJoinColumns = @JoinColumn(name="softwareId"))
	private Collection<Product> career=new ArrayList<Product>();
	
	public ResourcePerson(String name, String skills, Collection<Product> career) {
		super();
		this.name = name;
		this.skills = skills;
		this.career = career;
	}

	public Collection<Product> getCareer() {
		return career;
	}

	public void setCareer(Collection<Product> career) {
		this.career = career;
	}

	@Override
	public String toString() {
		return "ResourcePerson [id=" + id + ", name=" + name + ", skills=" + skills + ", career=" + career + "]";
	}
	
	
	/*
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="Info",joinColumns = @JoinColumn(name = "personId"),inverseJoinColumns = @JoinColumn(name="softwareId"))
	private Collection<Product> career=new ArrayList<Product>();
	
	@Override
	public String toString() {
		return "ResourcePerson [id=" + id + ", name=" + name + ", skills=" + skills + ", career=" + career + "]";
	}
	public ResourcePerson(String name, String skills, Collection<Product> career) {
		super();
		this.name = name;
		this.skills = skills;
		this.career = career;
	}
	public Collection<Product> getCareer() {
		return career;
	}
	public void setCareer(Collection<Product> career) {
		this.career = career;
	}
	*/
	
	
	/*
	@OneToOne
	@JoinColumn(name = "ProId")
	private Product product;
	
	public ResourcePerson(String name, String skills, Product product) {
		super();
		this.name = name;
		this.skills = skills;
		this.product = product;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	*/
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSkills() {
		return skills;
	}
	public void setSkills(String skills) {
		this.skills = skills;
	}
	public ResourcePerson(String name, String skills) {
		super();
		this.name = name;
		this.skills = skills;
	}

	/*
	 * @Override public String toString() { return "ResourcePerson [id=" + id +
	 * ", name=" + name + ", skills=" + skills + ", product=" + product + "]"; }
	 */
	public ResourcePerson() {
		super();
		// TODO Auto-generated constructor stub
	}
}
