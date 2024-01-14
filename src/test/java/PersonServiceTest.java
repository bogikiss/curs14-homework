import org.assertj.core.api.Assertions;
import org.fasttrackit.ex2.NonExistentIdException;
import org.fasttrackit.ex2.Person;
import org.fasttrackit.ex2.PersonService;
import org.junit.jupiter.api.Test;

import java.util.List;

public class PersonServiceTest {

    @Test
    public void testAddPerson() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                .name("Claire")
                .age(20)
                .build());

        PersonService personService = new PersonService(persons);

        //WHEN
        personService.addPerson(new Person("Maria", 21));

        //THEN
        Assertions.assertThat(personService.persons.size()).isEqualTo(2);
    }

    @Test
    public void testRemovePerson() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build());
        PersonService personService = new PersonService(persons);

        //WHEN
        personService.removePerson(2);

        //THEN
        Assertions.assertThat(personService.persons.size()).isEqualTo(1);
    }

    @Test
    public void testRemovePersonIfIdNonExistent() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build());
        int idToRemove = 10;
        PersonService personService = new PersonService(persons);

        //THEN
        org.junit.jupiter.api.Assertions.assertThrows(NonExistentIdException.class, () -> personService.removePerson(idToRemove));
    }

    @Test
    public void testGetAllPersons() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build(),
                Person.builder()
                        .name("Wanda")
                        .age(21)
                        .build());
        PersonService personService = new PersonService(persons);

        //WHEN
        List<Person> result = personService.getAllPersons();

        //THEN
        Assertions.assertThat(result).hasSize(3);
        Assertions.assertThat(result).extracting(Person::getName).containsExactlyInAnyOrder("Claire", "Maria", "Wanda");
    }

    @Test
    public void testGetPersonsOlderThan() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build(),
                Person.builder()
                        .name("Wanda")
                        .age(21)
                        .build());
        PersonService personService = new PersonService(persons);

        //WHEN
        int olderThan = 21;
        List<Person> result = personService.getPersonsOlderThan(olderThan);

        //THEN
        Assertions.assertThat(result).hasSize(1);
        Assertions.assertThat(result).extracting(Person::getName).containsExactlyInAnyOrder("Maria");
    }

    @Test
    public void testGetAllPersonNames() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build(),
                Person.builder()
                        .name("Wanda")
                        .age(21)
                        .build());
        PersonService personService = new PersonService(persons);

        //WHEN
        List<String> result = personService.getAllPersonNames();

        //THEN
        Assertions.assertThat(result).hasSize(3);
        Assertions.assertThat(result).containsExactlyInAnyOrder("Claire", "Maria", "Wanda");
    }

    @Test
    public void testGetPerson() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build(),
                Person.builder()
                        .name("Wanda")
                        .age(21)
                        .build());
        PersonService personService = new PersonService(persons);

        //WHEN
        Person result = personService.getPerson("Claire");

        //THEN
        Assertions.assertThat(result).extracting(Person::getName).isEqualTo("Claire");
        Assertions.assertThat(result).extracting(Person::getAge).isEqualTo(20);
    }

    @Test
    public void testGetPersonById() {
        //GIVEN
        List<Person> persons = List.of(Person.builder()
                        .name("Claire")
                        .age(20)
                        .build(),
                Person.builder()
                        .name("Maria")
                        .age(22)
                        .build(),
                Person.builder()
                        .name("Wanda")
                        .age(21)
                        .build());
        PersonService personService = new PersonService(persons);

        //WHEN
        Person result = personService.getPersonById(2);

        //THEN
        Assertions.assertThat(result).extracting(Person::getName).isEqualTo("Maria");
        Assertions.assertThat(result).extracting(Person::getId).isEqualTo(2);
    }
}
