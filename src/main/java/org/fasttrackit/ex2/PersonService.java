package org.fasttrackit.ex2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonService {
    public List<Person> persons = new ArrayList<>();

    public PersonService(List<Person> persons) {
        if (persons != null) {
            this.persons.addAll(persons);
        }
    }

    public void addPerson(Person person) {
        //persons.add(person);
        Collections.addAll(persons, person);
    }

    public void removePerson(int id) {
        List<Person> toRemove = new ArrayList<>();
        if (id < 0 || id > persons.size()) {
            throw new NonExistentIdException("There is no person with this id!");
        }
        for (Person person : persons) {
            if (id == person.getId()) {
                toRemove.add(person);
            }
        }
        persons.removeAll(toRemove);
        //System.out.println(persons);
    }

    public List<Person> getAllPersons() {
        List<Person> allPersons = new ArrayList<>();
        for (Person person : persons) {
            allPersons.add(person);
        }
        return allPersons;
    }

    public List<Person> getPersonsOlderThan(int age) {
        List<Person> personsOlderThan = new ArrayList<>();
        if (age > 0 && age < 120) {
            for (Person person : persons) {
                if (person.getAge() > age) {
                    personsOlderThan.add(person);
                }
            }
        }
        return personsOlderThan;
    }

    public List<String> getAllPersonNames() {
        List<String> allPersonsNames = new ArrayList<>();
        for (Person person : persons) {
            allPersonsNames.add(person.getName());
        }
        return allPersonsNames;
    }

    public Person getPerson(String name) {
        Person result = null;
        for (Person person : persons) {
            if (name.equals(person.getName())) {
                result = person;
            }
        }
        return result;
    }

    public Person getPersonById(int id) {
        Person result = null;
        for (Person person : persons) {
            if (id == person.getId()) {
                result = person;
            }
        }
        return result;
    }
}
