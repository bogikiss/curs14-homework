package org.fasttrackit.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = new ArrayList<>();
        Person person1 = new Person("Anne", 20);
        Person person2 = new Person("Lydia", 23);
        Person person3 = new Person("Hannah", 23);
        Person person4 = new Person("Chloe", 21);
        Collections.addAll(persons, person1, person2);

        PersonService personService = new PersonService(persons);
        System.out.println(persons);
        personService.addPerson(person3);
        personService.removePerson(1);
        personService.addPerson(person4);
        System.out.println(personService.getAllPersons());
        System.out.println(personService.getPersonsOlderThan(21));
        System.out.println(personService.getAllPersonNames());
        System.out.println(personService.getPerson("Hannah"));
        System.out.println(personService.getPersonById(4));

    }
}
