package ru.alishev.springcourse.DAO;

import org.springframework.stereotype.Component;
import ru.alishev.springcourse.controllers.PeopleController;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private List<Person> people;
    private int counter = 0;

    {
        people = new ArrayList<>();
        people.add(new Person("Kate", ++counter));
        people.add(new Person("Tom", ++counter));
        people.add(new Person("Ivan", ++counter));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void add(String name) {
        people.add(new Person(name, ++counter));
    }
}
