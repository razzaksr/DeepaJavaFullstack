package basics.maven.hiber.DeepaHibernate.week2;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "freelancer")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Resource
{
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_skills")
	private String tech;
	@Column(name = "emp_exp")
	private Integer experience;
	
	public Resource( String name, String tech, Integer experience) {
		super();
		this.name = name;
		this.tech = tech;
		this.experience = experience;
	}
	public Resource(int num, String name, String tech, Integer experience) {
		super();
		this.num = num;
		this.name = name;
		this.tech = tech;
		this.experience = experience;
	}
	@Override
	public String toString() {
		return "Resource [num=" + num + ", name=" + name + ", tech=" + tech + ", experience="
				+ experience + "]";
	}
	public Resource() {
		super();
		// TODO Auto-generated constructor stub
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
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
}
