package ser.jir.parsing.service;

import org.springframework.stereotype.Service;
import ser.jir.parsing.models.Person;

import java.util.List;

@Service
public interface ParsingService {

    void save(Person person);


    List<Person> getPerson();
}
