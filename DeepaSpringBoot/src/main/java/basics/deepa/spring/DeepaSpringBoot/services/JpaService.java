package basics.deepa.spring.DeepaSpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import basics.deepa.spring.DeepaSpringBoot.entities.Forum;
import basics.deepa.spring.DeepaSpringBoot.repositories.ForumResposoitory;

@Service
public class JpaService 
{
	@Autowired
	ForumResposoitory repo;
	
	public Forum insertings(Forum forum)
	{
		return repo.save(forum);
	}
	
	public String inserting(Forum forum)
	{
		return repo.save(forum).getName()+" has inserted";
	}
	
	public List<Forum> every()
	{
		return repo.findAll();
	}
	
	public Forum reachOne(Integer id)
	{
		return repo.findById(id).orElse(new Forum());
	}
	
	public String eraseOne(Integer id)
	{
		String hai=reachOne(id).getName()+" has deleted";
		repo.deleteById(id);
		return hai;
	}
	
	public String eraseObject(Forum forum)
	{
		String hai=forum.getName()+" has deleted";
		repo.delete(forum);
		return hai;
	}
}