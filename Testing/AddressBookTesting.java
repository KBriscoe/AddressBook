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

    @Test
    void testEditPerson(){
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Add person to mockAddressBook
        mockAddressBook.add(mockPerson);
        Person editedMockPerson = new Person("William", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Use set to adjust mockPerson to edited mockPerson
        mockAddressBook.set(0, editedMockPerson);
        //Check that the updated person is equal to our edited Person
        assertEquals(mockAddressBook.get(0), editedMockPerson);
    }

    @Test
    void testClearAll(){
        AddressBook mockAddressBook = new AddressBook();
        //Attempt clear on empty address book
        assertDoesNotThrow(() -> mockAddressBook.clear());
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Add person to mockAddressBook
        mockAddressBook.add(mockPerson);
        //Attempt clear on filled address book
        assertDoesNotThrow(() -> mockAddressBook.clear());
    }

    @Test
    void testGetCount(){
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Add person to mockAddressBook
        mockAddressBook.add(mockPerson);
        assertEquals(1, mockAddressBook.getRowCount());
        //Each person has 7 attributes
        assertEquals(7, mockAddressBook.getColumnCount());
    }

    @Test
    void testGetValueAt(){
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Add person to mockAddressBook
        mockAddressBook.add(mockPerson);
        assertEquals(mockPerson.getFirstName(), mockAddressBook.getValueAt(0,1));
    }

    @Test
    void testGetColumnName(){
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Add person to mockAddressBook
        mockAddressBook.add(mockPerson);
        assertEquals("Last Name", mockAddressBook.getColumnName(0));
    }
}
