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
        people.add(new Person("Kate", ++counter, 22, "kate@gmail.com"));
        people.add(new Person("Tom", ++counter, 34, "tom@gmail.com"));
        people.add(new Person("Ivan", ++counter, 11, "ivan@gmail.com"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public void add(String name, int age, String email) {
        people.add(new Person(name, ++counter, age, email));
    }

    public void add(Person person) {
        person.setId(++counter);
        people.add(person);
    }

    public void edit(int id, Person person) {
        Person toBeUpdated = show(id);
        toBeUpdated.setName(person.getName());
        toBeUpdated.setAge(person.getAge());
        toBeUpdated.setEmail(person.getEmail());
    }
}
