package basics.maven.hiber.DeepaHibernate.week3;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Stuffs 
{
	@Column(name = "ingeriediants")
	private String items;
	@Column(name = "count")
	private int levels;
	@Column(name = "making")
	private String process;
	public Stuffs() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Stuffs(String items, int levels, String process) {
		super();
		this.items = items;
		this.levels = levels;
		this.process = process;
	}
	@Override
	public String toString() {
		return "Stuffs [items=" + items + ", levels=" + levels + ", process=" + process + "]";
	}
	public String getItems() {
		return items;
	}
	public void setItems(String items) {
		this.items = items;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public String getProcess() {
		return process;
	}
	public void setProcess(String process) {
		this.process = process;
	}
}
