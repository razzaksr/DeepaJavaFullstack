package basic.orm.hiber.HibernateBasics.dayone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PenService 
{
	@Autowired
	PenInterface remote;
	
	public String addingNew(Pen pen)
	{
		return remote.save(pen).getModel();
	}
}
