package es.uma.mps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Class PersonTest contains tests for verifying the correctness of the Person class and its methods.
 * The tests verify the creation of Person objects, the calculation of average age per gender and the exception handling.
 *
 * @author Jorge Camacho García
 */
class PersonTest {
    Person person;

    @AfterEach
    void shutdown(){ person = null;}

    /**
     * Test to verify the handling of an empty name in the Person class.
     * Expects a BadArgumentsException to be thrown when a Person is created with an empty name.
     */
    @Test
    void unnamedPerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("",68,"Female"));
    }

    /**
     * Test to verify the handling of negative age in the Person class.
     * Expects a BadArgumentsException to be thrown when a Person is created with negative age.
     */
    @Test
    void negativeAgePerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("Alice",-20, "Female"));
    }

    /**
     * Test to verify the handling of empty gender in the Person class.
     * Expects a BadArgumentsException to be thrown when a Person is created with an empty gender.
     */
    @Test
    void emptyGenderPerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("Bob", 34, ""));
    }


    /**
     * Test to verify the handling of undefined gender in the Person class.
     * Expects a BadArgumentsException to be thrown when a Person is created with an undefined gender.
     */
    @Test
    void notIdentifiedGenderPerson(){
        assertThrows(BadArgumentsException.class, () -> person = new Person("Bob", 34, "Random"));
    }

    /**
     * Test to verify the correct creation of a Person object.
     * Expects the created Person object to have the same name, age, and gender as the input parameters.
     */
    @Test
    void correctPersonCreation(){
        String name = "Charles", gender = "Male";
        int age =25;

        person = new Person(name,age,gender);

        assertEquals(name, person.getName());
        assertEquals(age,person.getAge());
        assertEquals(gender,person.getGender());
    }

    /**
     * Test to verify the calculation of average age per gender in a list of Person objects, with 2 males and 3 females.
     * Expects the Male average to be 27.5 and the Female average to be 28.6.
     */
    @Test
    public void averageAgeOn2MalesAnd3Females() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("John", 25, "Male"));
        persons.add(new Person("Michael", 30, "Male"));
        persons.add(new Person("Jane", 28, "Female"));
        persons.add(new Person("Emily", 26, "Female"));
        persons.add(new Person("Sarah", 32, "Female"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(27.5, result[0], 0.1);
        assertEquals(28.6, result[1], 0.1);
    }

    /**
     * Test to verify the calculation of average age per gender in an empty list of Person objects.
     * Expects the result to be NaN for both Male and Female averages.
     */
    @Test
    public void averageAgeOnEmptyList(){
        double[] result = Person.averageAgePerGender(new ArrayList<Person>());

        assertEquals(Double.NaN, result[0]);
        assertEquals(Double.NaN, result[1]);
    }

    /**
     * Test to verify the calculation of average age per gender in a
     * list of Person objects containing 3 males and 0 females.
     * Expects the Male average to be 46 and the Female average to be NaN.
     */
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

    /**
     * Test to verify the calculation of average age per gender in a list
     * of Person objects containing 1 Male and 1 Female.
     * Expects the Male average to be 31 and the Female average to be 57.
     */
    @Test
    public void averageAgeOn1MaleAnd1Female(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Lucas", 31, "Male"));
        persons.add(new Person("Michelle", 57, "Female"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(31, result[0]);
        assertEquals(57, result[1]);
    }

    /**
     * Test to verify the calculation of average age per gender in a list of Person objects containing 1 male and 4 females.
     * Expects the Male average to be 21 and the Female average to be 43.5.
     */
    @Test
    public void averageAgeOn1MaleAnd4Females(){
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Bob", 21, "Male"));
        persons.add(new Person("Michael", 54, "Female"));
        persons.add(new Person("Jane", 23, "Female"));
        persons.add(new Person("Emily", 42, "Female"));
        persons.add(new Person("Sarah", 55, "Female"));

        double[] result = Person.averageAgePerGender(persons);

        assertEquals(21, result[0]);
        assertEquals(43.5, result[1], 0.1);
    }
}