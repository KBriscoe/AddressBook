package Testing;

//Testing imports

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//Modules
import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.FileSystem;
import AddressBook.Person;

//Imports
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;


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

    @ParameterizedTest
    @ValueSource(strings = {"12345 House Rd", "9594 Community Lane", "123 Address Cir"})
    void testPersonAddressInput(String input) {
        String addressPattern = "(\\d{1,5}\\s[a-z]+\\s[a-z]+)";
        assertTrue(input.matches(addressPattern));
    }

    @ParameterizedTest
    @ValueSource(strings = {"error", "#$%$ Community Lane", "123 1234 123445"})
    void testPersonNegativeAddressInput(String input) {
        String addressPattern = "(\\d{1,5}\\s[a-z]+\\s[a-z]+)";
        assertFalse(input.matches(addressPattern));
    }
}
