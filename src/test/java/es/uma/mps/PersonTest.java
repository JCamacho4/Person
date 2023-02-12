package es.uma.mps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @AfterEach
    void shutdown(){ person = null;}

    @Test
    void unnamedPerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("",68,"Female"));
    }

    @Test
    void negativeAgePerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("Alice",-20, "Female"));
    }

    @Test
    void emptyGenderPerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("Bob", 34, ""));
    }

    @Test
    void notIdentifiedGenderPerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("Bob", 34, "Random"));
    }

    @Test
    void correctPersonCreation(){
        String name = "Charles", gender = "Male";
        int age =25;

        person = new Person(name,age,gender);

        assertEquals(name, person.getName());
        assertEquals(age,person.getAge());
        assertEquals(gender,person.getGender());
    }

    @Test
    public void averageAgeOn2MalesAnd3Females() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 25, "Male"));
        persons.add(new Person("Michael", 30, "Male"));
        persons.add(new Person("Jane", 28, "Female"));
        persons.add(new Person("Emily", 26, "Female"));
        persons.add(new Person("Sarah", 32, "Female"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(27.5, result[0], 0.1); // Male average age should be 27.5
        assertEquals(28.6, result[1], 0.1); // Female average age should be 29
    }

    @Test
    public void averageAgeOnEmptyList(){
        double[] result = Person.averageAgePerGender(new ArrayList<Person>());

        assertEquals(Double.NaN, result[0]);
        assertEquals(Double.NaN, result[1]);
    }

    @Test
    public void averageAgeOn3MalesAnd0Females(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 42, "Male"));
        persons.add(new Person("Michael", 80, "Male"));
        persons.add(new Person("James", 16, "Male"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(46, result[0], 0.1);
        assertEquals(Double.NaN, result[1]);
    }

    @Test
    public void averageAgeOn1MaleAnd1Female(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Lucas", 31, "Male"));
        persons.add(new Person("Michelle", 57, "Female"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(31, result[0]);
        assertEquals(57, result[1]);
    }

    @Test
    public void averageAgeOn1MaleAnd4Females(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob", 21, "Male"));
        persons.add(new Person("Michael", 54, "Female"));
        persons.add(new Person("Jane", 23, "Female"));
        persons.add(new Person("Emily", 42, "Female"));
        persons.add(new Person("Sarah", 55, "Female"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(21, result[0]); // Male average age should be 27.5
        assertEquals(43.5, result[1], 0.1); // Female average age should be 29
    }
}