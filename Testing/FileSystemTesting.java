package Testing;

import AddressBook.AddressBook;
import AddressBook.Person;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.stream.Stream;

public class FileSystemTesting {

    //Mock Save Function for Load Test
    private static Stream<Arguments> mockSaveAddressBook() {
        AddressBook mockAddressBook = new AddressBook();
        File file = new File("test_outputs/testfile.txt");
        return Stream.of(Arguments.of(mockAddressBook, file));
    }

    @ParameterizedTest
    @MethodSource("mockSaveAddressBook")
    public void saveFile(AddressBook addressBook, File file) throws IOException, SQLException {
        // Create the table structure using the mock file path
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + file.getAbsolutePath());
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE IF EXISTS persons");
        statement.execute("CREATE TABLE persons (firstName TEXT, lastName TEXT, address TEXT, city TEXT, state TEXT, zip TEXT, phone TEXT)");
        // Insert the data into the database
        PreparedStatement insert = connection.prepareStatement("INSERT INTO persons (lastName, firstName, address, city, state, zip, phone) VALUES (?, ?, ?, ?, ?, ?, ?)");
        for (Person p : addressBook.getPersons()) {
            for (int i = 0; i < Person.fields.length; i++) {
                insert.setString(i + 1, p.getField(i));
            }
            insert.executeUpdate();
        }

        connection.close();
    }
}
