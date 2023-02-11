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
        assertThrows(RuntimeException.class, () -> person = new Person("",68,"Female"));
    }

    @Test
    void negativeAgePerson(){
        assertThrows(RuntimeException.class, () -> person = new Person("Alice",-20, "Female"));
    }

    @Test
    void notIdentifiedGenderPerson(){
        assertThrows(RuntimeException.class, () -> person = new Person("Bob", 34, ""));
    }

}