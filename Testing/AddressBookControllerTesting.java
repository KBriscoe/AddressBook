package Testing;

import AddressBook.AddressBookController;
import AddressBook.AddressBook;
import AddressBook.Person;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AddressBookControllerTesting {
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
}
