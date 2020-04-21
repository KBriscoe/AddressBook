package Testing;

import AddressBook.AddressBookController;
import AddressBook.AddressBook;
import AddressBook.Person;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

public class AddressBookControllerTesting {

    @Test
    void testEditPerson(){
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        AddressBookController controller = new AddressBookController(mockAddressBook);
        //Add person to mockAddressBook
        controller.add(mockPerson);
        Person editedMockPerson = new Person("William", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        //Use set to adjust mockPerson to edited mockPerson
        controller.set(0, editedMockPerson);
        //Check that the updated person is equal to our edited Person
        assertEquals(controller.get(0), editedMockPerson);
    }

    @Test
    void testAddPerson(){
        //test adding a person to the address book
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        AddressBookController controller = new AddressBookController(mockAddressBook);
        controller.add(mockPerson);
        assertEquals(controller.get(0), mockPerson);
    }

    @Test
    void testRemovePerson(){
        //test removing a person in the address book
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        AddressBookController controller = new AddressBookController(mockAddressBook);
        controller.add(mockPerson);
        controller.remove(0);
        assertThrows(IndexOutOfBoundsException.class, () -> controller.get(0));
    }

    @Test
    void testClearAll(){
        //Test clearing the entire address book
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        AddressBookController controller = new AddressBookController(mockAddressBook);
        controller.add(mockPerson);
        controller.clear();
        assertThrows(IndexOutOfBoundsException.class, () -> controller.get(0));
    }

    @Test
    void testOpenAddressBook() throws IOException, SQLException {
        AddressBook mockAddressBook = new AddressBook();
        AddressBookController controller = new AddressBookController(mockAddressBook);
        File file = new File("test_outputs/testfile");
        controller.save(file);
        assertDoesNotThrow(() -> controller.open(file));
    }
}
