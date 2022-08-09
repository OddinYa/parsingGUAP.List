package ser.jir.parsing.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Comparator;
import java.util.Objects;


@Entity
@Getter
@Setter

public class Person implements Comparable<Person> {



    @Id
    private String numberId;

    private String score;

    private int numb;

    public void setNumb(int numb) {
        this.numb = numb;
    }

    public Person(String id, String score){
        this.numberId=id;
        this.score = score;
    }
    public Person(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;

        return Objects.equals(numberId, person.numberId);
    }

    @Override
    public int hashCode() {
        return 1422108840;
    }

    @Override
    public int compareTo(Person o) {
        Integer f = Integer.parseInt(this.score);
        Integer s = Integer.parseInt(o.score);
        return s.compareTo(f);
    }
}
