package ser.jir.parsing.job;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ser.jir.parsing.models.Person;
import ser.jir.parsing.service.ParsingService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ParseTaskStudent {

    private List<Person> people = new ArrayList<>();

    @Autowired
    ParsingService parsingService;

    @Scheduled(fixedDelay = 50000)
    public void parsePercon() throws IOException {

        String url = "https://priem.guap.ru/_lists/List_1364_15";
        
        int count = 0;

        Document document = Jsoup.connect(url)
                .userAgent("Mozilla")
                .timeout(10000)
                .referrer("https://google.com")
                .get();


        Elements listOfPeople = document.select("tr");

        for (Element man : listOfPeople) {

            Elements strMan = man.select("td");

            if (count > 0) {
                List<String> strList = new ArrayList<>();

                for (Element el : strMan) {

                    strList.add(el.text());
                }

                if (strList.get(6).equals("Да")) {

                    Person person = new Person(strList.get(0), strList.get(2));
                    people.add(person);

                }
            }
            count++;
        }

        people = people.stream().sorted().collect(Collectors.toList());

        for (int i = 0; i < people.size(); i++) {
            people.get(i).setNumb(i+1);
            parsingService.save(people.get(i));
        }


    }
}

