package ser.jir.parsing.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ser.jir.parsing.job.ParseTaskStudent;
import ser.jir.parsing.models.Person;
import ser.jir.parsing.service.ParsingService;


import java.io.IOException;
import java.util.List;

@RestController
public class PeopleController {


    @Autowired
    ParsingService parsingService;
    @Autowired
    ParseTaskStudent parseTaskStudent;


    @GetMapping(value = "/list")
    public List<Person> getsortList() throws IOException {
        parseTaskStudent.parsePercon();
        return parsingService.getPerson();
    }
}
