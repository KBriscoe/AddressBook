package Testing;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.Person;
import AddressBook.FileSystem;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileSystemTesting {

    //Mock inputs for Save Test - Stub to test save function
    private static Stream<Arguments> mockSaveAddressBookInputs() {
        AddressBook mockAddressBook = createMockAddressBookObject();
        File file = createMockFileObject();
        return Stream.of(Arguments.of(mockAddressBook, file));
    }

    private static Stream<Arguments> mockLoadAddressBookInputs() {
        AddressBook mockAddressBook = createMockAddressBookObject();
        File file = createMockFileObject();
        return Stream.of(Arguments.of(mockAddressBook, file));
    }

    private static Stream<Arguments> mockFailAddressBookInputs() {
        AddressBook mockAddressBook = createMockAddressBookObject();
        File file = new File("fakelocation");
        return Stream.of(Arguments.of(mockAddressBook, file));
    }

    //this method creates a mock Addressbook with a person in it
    private static AddressBook createMockAddressBookObject(){
        AddressBook mockAddressBook = new AddressBook();
        Person mockPerson = new Person("Mark", "John", "5567 Colonial Blvd",
                "Fort Myers", "Florida", "33919", "9804098567");
        mockAddressBook.add(mockPerson);
        return mockAddressBook;
    }

    //this method creates a mock File object with the testing output path
    private static File createMockFileObject() {
        File file = new File("test_outputs/testfile");
        return file;
    }

    //this function tests the save file function using the input mock stub
    @ParameterizedTest
    @MethodSource("mockSaveAddressBookInputs")
    public void testSaveFile(AddressBook mockAddressBook, File file) throws IOException, SQLException {
        AddressBookController mockController = new AddressBookController(mockAddressBook);
        assertDoesNotThrow(() -> mockController.save(file));
    }

    //this function tests the save file function using the input mock stub
    @ParameterizedTest
    @MethodSource("mockLoadAddressBookInputs")
    public void testLoadFile(AddressBook mockAddressBook, File file) throws IOException, SQLException {
        AddressBookController mockController = new AddressBookController(mockAddressBook);
        mockController.save(file);
        assertDoesNotThrow(() -> new FileSystem().readFile(mockAddressBook, file));
    }

    @ParameterizedTest
    @MethodSource("mockFailAddressBookInputs")
    public void testFailLoadFile(AddressBook mockAddressBook, File file) throws IOException, SQLException {
        assertThrows(FileNotFoundException.class, () -> new FileSystem().readFile(mockAddressBook, file));
    }


}
