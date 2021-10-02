package basic.orm.hiber.HibernateBasics.dayone;

import org.springframework.beans.factory.annotation.Autowired;

public class InsertingRecords 
{
	@Autowired
	static PenService service;
	public static void main(String[] args) 
	{
		Pen pen1=new Pen("Vista20", "Camel", "Blue", 10, 100);
		service.addingNew(pen1);	
	}
}
