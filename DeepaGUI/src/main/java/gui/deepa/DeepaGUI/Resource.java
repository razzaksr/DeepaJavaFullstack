package gui.deepa.DeepaGUI;

import java.io.Serializable;
import java.util.Arrays;

public class Resource implements Serializable
{
	private String name;
	private String[] tech;
	private Integer experience;
	@Override
	public String toString() {
		return "Resource [name=" + name + ", tech=" + Arrays.toString(tech) + ", experience="
				+ experience + "]\n";
	}
	public Resource(String name, String[] tech, Integer experience) {
		super();
		this.name = name;
		this.tech = tech;
		this.experience = experience;
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
	public String[] getTech() {
		return tech;
	}
	public void setTech(String[] tech) {
		this.tech = tech;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
}
