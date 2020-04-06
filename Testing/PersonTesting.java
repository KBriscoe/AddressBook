package Testing;

import AddressBook.AddressBook;
import AddressBook.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class PersonTesting {

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

    //Testing valid address input in format: 1-5 numbers space word space word
    @ParameterizedTest
    @ValueSource(strings = {"12345 House Rd", "9594 Community Lane", "123 Address Cir"})
    void testPersonAddressInput(String input) {
        String addressPattern = "(\\d{1,5}\\s([a-z]|[A-Z])+\\s([a-z]|[A-Z])+)";
        assertTrue(input.matches(addressPattern));
    }

    //Testing invalid address input
    @ParameterizedTest
    @ValueSource(strings = {"error", "#$%$ Community Lane", "123 1234 123445"})
    void testPersonNegativeAddressInput(String input) {
        String addressPattern = "(\\d{1,5}\\s([a-z]|[A-Z])+\\s([a-z]|[A-Z])+)";
        assertFalse(input.matches(addressPattern));
    }

    //Testing valid phone input
    @ParameterizedTest
    @ValueSource(strings = {"(233)-344-5555", "123-456-789", "1231234123445"})
    void testPersonPhoneInput(String input) {
        String phonePattern = "((\\d|\\-|\\(|\\)|\\s)+)";
        assertTrue(input.matches(phonePattern));
    }

    //Testing valid phone input
    @ParameterizedTest
    @ValueSource(strings = {"123 333 abc", "1^&$$$#%#@", "not a phone number"})
    void testPersonNegativePhoneInput(String input) {
        String phonePattern = "((\\d|\\-|\\(|\\)|\\s)+)";
        assertFalse(input.matches(phonePattern));
    }

}
