package iron.tec.labs.security.demo.repository;

import iron.tec.labs.security.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.name =:name")
    User getFirstByName(@Param("name") String name);
}
