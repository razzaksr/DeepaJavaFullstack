package basic.orm.hiber.HibernateBasics.dayone;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenInterface extends CrudRepository<Pen, Integer>
{

}
