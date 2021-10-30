package basics.deepa.spring.DeepaSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import basics.deepa.spring.DeepaSpringBoot.entities.Forum;

@Repository
public interface ForumResposoitory extends JpaRepository<Forum, Integer>
{
	
}
