package es.uma.mps;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

}