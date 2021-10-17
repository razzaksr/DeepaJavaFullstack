package basics.maven.hiber.DeepaHibernate.week4;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Course 
{
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
private int cNo;
private String CrsName;
private String Department;

public Course(String crsName, String department) {
	super();
	CrsName = crsName;
	Department = department;
}
public Course(int cNo, String crsName, String department) {
	super();
	this.cNo = cNo;
	CrsName = crsName;
	Department = department;
}
public Course() {
	super();
	// TODO Auto-generated constructor stub
}
public int getcNo() {
	return cNo;
}
public void setcNo(int cNo) {
	this.cNo = cNo;
}
public String getCrsName() {
	return CrsName;
}
public void setCrsName(String crsName) {
	CrsName = crsName;
}
public String getDepartment() {
	return Department;
}
public void setDepartment(String department) {
	Department = department;
}
@Override
public String toString() {
	return "Course [cNo=" + cNo + ", CrsName=" + CrsName + ", Department=" + Department + "]";
}




}
