package Testing;

//Testing imports

import AddressBook.AddressBook;
import AddressBook.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

//Modules
//Imports


public class UnitTesting {

    @Test
    void testPerson() {
        //Testing missing first name
        assertThrows(IllegalArgumentException.class, () -> new Person("", "Name", "12345 Address Road",
                "City Name", "State Name", "12345", "1-234-567-8910"));

        //Testing missing last name
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", "", "12345 Address Road",
                "City Name", "State Name", "12345", "1-234-567-8910"));
/*
        //Testing missing address
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", "Name", "",
                "City Name", "State Name", "12345", "1-234-567-8910"));

        //Testing missing city
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", "Name", "12345 Address Road",
                "", "State Name", "12345", "1-234-567-8910"));

        //Testing missing state
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", "Name", "12345 Address Road",
                "City Name", "", "12345", "1-234-567-8910"));

        //Testing missing zip
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", "Name", "12345 Address Road",
                "City Name", "State Name", "", "1-234-567-8910"));

        //Testing missing phone number
        assertThrows(IllegalArgumentException.class, () -> new Person("Test", "Name", "12345 Address Road",
                "City Name", "State Name", "12345", ""));

*/
    }

    // Testing creating new AddressBook and Person objects and adding Person to AddressBook
    @Test
    void testAddPerson() {
        AddressBook mockBook = new AddressBook();
        Person mockPerson = new Person("Mark", "Smith", " 1357 Java Lane",
                "Fort Myers", "Florida", "33907", "1234567890");
        mockBook.add(mockPerson);
        assertEquals(mockPerson, mockBook.get(0));
    }

    // Testing creating new AddressBook and Person objects and deleting Person from AddressBook
    @Test
    void testDeletePerson() {
        AddressBook mockBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        mockBook.add(mockPerson);
        mockBook.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () -> mockBook.get(0));
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345 House Rd", "9594 Community Lane", "123 Address Cir"})
    void testPersonAddressInput(String input) {
        String addressPattern = "(\\d{1,5}\\s([a-z]|[A-Z])+\\s([a-z]|[A-Z])+)";
        assertTrue(input.matches(addressPattern));
    }

    @ParameterizedTest
    @ValueSource(strings = {"error", "#$%$ Community Lane", "123 1234 123445"})
    void testPersonNegativeAddressInput(String input) {
        String addressPattern = "(\\d{1,5}\\s([a-z]|[A-Z])+\\s([a-z]|[A-Z])+)";
        assertFalse(input.matches(addressPattern));
    }
}
