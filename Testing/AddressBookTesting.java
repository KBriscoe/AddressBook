package Testing;

import AddressBook.AddressBook;
import AddressBook.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookTesting {

    @Test
    void testCreateAddressBook(){
        //Create new addressbook object
        AddressBook mockAddressBook = new AddressBook();
        //Assert that the class created matches the class Addressbook
        assertEquals((new AddressBook().getClass()), mockAddressBook.getClass());
    }

    // Testing creating new AddressBook and Person objects and adding Person to AddressBook
    @Test
    void testAddPerson() {
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "Smith", " 1357 Java Lane",
                "Fort Myers", "Florida", "33907", "1234567890");
        mockAddressBook.add(mockPerson);
        //Test if get at index 0 of mockAddressBook gets the equivalent mock object
        assertEquals(mockPerson, mockAddressBook.get(0));
    }

    // Testing creating new AddressBook and Person objects and deleting Person from AddressBook
    @Test
    void testDeletePerson() {
        //Testing Removing Person from single person address book
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        mockAddressBook.add(mockPerson);
        //Remove Person at index 0
        mockAddressBook.remove(0);
        //Test if get at index 0 of mockAddressBook throws IOB exception
        assertThrows(IndexOutOfBoundsException.class, () -> mockAddressBook.get(0));
    }
}
