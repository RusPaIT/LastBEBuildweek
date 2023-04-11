package it.epicode.be.epicenergyservices.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import it.epicode.be.epicenergyservices.models.User;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE username = :u")
	Optional<User> findUserByUsername(@Param("u") String u);
	
	@Query(nativeQuery = true, value = "SELECT * FROM users WHERE email = :e")
	Optional<User> findUserByEmail(@Param("e") String e);
	
	Boolean existsByUsername(String u);

	Boolean existsByEmail(String e);

}
