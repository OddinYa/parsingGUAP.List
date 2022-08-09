package ser.jir.parsing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ser.jir.parsing.models.Person;
import ser.jir.parsing.repository.PersonRepo;

import java.util.List;

@Service
public class ParsingServiceImpl implements ParsingService  {

    @Autowired
    private PersonRepo repo;


    @Override
    public void save(Person person) {
        repo.save(person);
    }


    @Override
    public List<Person> getPerson() {
        return repo.findAll();
    }
}
