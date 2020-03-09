package Testing;

//Testing imports
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.FileSystem;
import AddressBook.Person;

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
}
