package Testing;

import AddressBook.AddressBook;
import AddressBook.AddressBookController;
import AddressBook.Person;
import GUI.AddressBookGUI;
import GUI.PersonDialog;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class GUITesting {
    //Set up
    AddressBook addressBook = new AddressBook();
    AddressBookController controller = new AddressBookController(addressBook);
    AddressBookGUI parent = new AddressBookGUI(controller, addressBook);
    Person mockPerson = new Person("Mark", "Smith", " 1357 Java Lane",
            "Fort Myers", "Florida", "33907", "1234567890");

    //Identify the input field by the name attribute
    public static Component getChildNamed(Component parent, String name){
        if(name.equals(parent.getName())) {
            return parent;
        }
        if(parent instanceof Container) {
            Component[] children = ((Container)parent).getComponents();

            for(int i=0; i<children.length; ++i){
                Component child = getChildNamed(children[i], name);
                if(child != null) {
                    return child;
                }
            }
        }
        return null;
    }

    @Test
    void testPersonDialogueInput(){
        //Test dialog
        PersonDialog dialog = new PersonDialog(parent);
        String inputString = "Test";
        String addressString = "12345 Address Rd";
        String phoneString = "239-555-5555";
        String zipString = "12345";
        //FirstName
        JTextField fnInput = (JTextField) GUITesting.getChildNamed(dialog, "firstName");
        fnInput.setText(inputString);
        //confirm our test string is equal
        assertEquals(inputString, fnInput.getText());
        JTextField lnInput = (JTextField) GUITesting.getChildNamed(dialog, "lastName");
        lnInput.setText(inputString);
        //confirm our test string is equal
        assertEquals(inputString, lnInput.getText());
        JTextField addressInput = (JTextField) GUITesting.getChildNamed(dialog, "address");
        addressInput.setText(addressString);
        //confirm our test string is equal
        assertEquals(addressString, addressInput.getText());
        JTextField cityInput = (JTextField) GUITesting.getChildNamed(dialog, "city");
        cityInput.setText(inputString);
        //confirm our test string is equal
        assertEquals(inputString, cityInput.getText());
        JTextField stateInput = (JTextField) GUITesting.getChildNamed(dialog, "state");
        stateInput.setText(inputString);
        //confirm our test string is equal
        assertEquals(inputString, stateInput.getText());
        JTextField zipInput = (JTextField) GUITesting.getChildNamed(dialog, "zip");
        zipInput.setText(zipString);
        //confirm our test string is equal
        assertEquals(zipString, zipInput.getText());
        JTextField phoneInput = (JTextField) GUITesting.getChildNamed(dialog, "phone");
        phoneInput.setText(phoneString);
        //confirm our test string is equal
        assertEquals(phoneString, phoneInput.getText());
        //Programmatically find the OK button

        JButton okButton = (JButton) GUITesting.getChildNamed(dialog, "okButton");
        //if the dialogue result is not OK
        if (dialog.showDialog() == PersonDialog.Result.OK) {
            assertTrue(true);
        }else {
            assertTrue(false);
        }
    }

    @Test
    void testEditPerson(){
        PersonDialog dialog = new PersonDialog(parent, mockPerson);
        //Assert that the fields are equal to our mock person
        JTextField fnInput = (JTextField) GUITesting.getChildNamed(dialog, "firstName");
        assertEquals(fnInput.getText(), mockPerson.getFirstName());
        JTextField lnInput = (JTextField) GUITesting.getChildNamed(dialog, "lastName");
        assertEquals(lnInput.getText(), mockPerson.getLastName());
        JTextField addressInput = (JTextField) GUITesting.getChildNamed(dialog, "address");
        assertEquals(addressInput.getText(), mockPerson.getAddress());
        JTextField cityInput = (JTextField) GUITesting.getChildNamed(dialog, "city");
        assertEquals(cityInput.getText(), mockPerson.getCity());
        JTextField stateInput = (JTextField) GUITesting.getChildNamed(dialog, "state");
        assertEquals(stateInput.getText(), mockPerson.getState());
        JTextField zipInput = (JTextField) GUITesting.getChildNamed(dialog, "zip");
        assertEquals(zipInput.getText(), mockPerson.getZip());
        JTextField phoneInput = (JTextField) GUITesting.getChildNamed(dialog, "phone");
        assertEquals(phoneInput.getText(), mockPerson.getPhone());
    }

    @Test
    void testGetPersonDialog(){
        PersonDialog dialog = new PersonDialog(parent, mockPerson);
        assertEquals(dialog.getPerson().getFirstName(), mockPerson.getFirstName());
        assertEquals(dialog.getPerson().getLastName(), mockPerson.getLastName());
        assertEquals(dialog.getPerson().getAddress(), mockPerson.getAddress());
        assertEquals(dialog.getPerson().getCity(), mockPerson.getCity());
        assertEquals(dialog.getPerson().getState(), mockPerson.getState());
        assertEquals(dialog.getPerson().getZip(), mockPerson.getZip());
        assertEquals(dialog.getPerson().getPhone(), mockPerson.getPhone());
    }
}
