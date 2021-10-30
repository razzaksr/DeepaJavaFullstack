package basics.deepa.spring.DeepaSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import basics.deepa.spring.DeepaSpringBoot.entities.Forum;

@Repository
public interface ForumResposoitory extends JpaRepository<Forum, Integer>
{

	public Forum findByMembersCount(int count);
	
	
	@Query("from Forum where productionHours >= :hours")
	public List<Forum> findByProductionHours(int hours);
	
	@Query("Select name from Forum where membersCount >= :count")
	public List<String> gettingNamesByCount(int count);
	
}
