package ser.jir.parsing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ser.jir.parsing.models.Person;

@Repository
public interface PersonRepo extends JpaRepository<Person,String> {
}
