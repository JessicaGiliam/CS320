package cs320;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// The ContactService class should be able to:
//   * Create contacts with a unique ID
//   * Delete contacts via the unique ID
//   * Update each field within the contact, except for ID.
public class ContactServiceTest {

    // Ensure that the ContactService class can create contacts, with an assigned ID.
    @Test
    public void CreateContact() {
        ContactService service = new ContactService();
        String id = service.addContact("First", "Last", "Phone", "Address");
        assertNotNull(id);
        assertEquals(id.length(), 10);

        Contact contact = service.getContact(id);
        assertEquals(contact.getFirstName(), "First");
        assertEquals(contact.getLastName(), "Last");
        assertEquals(contact.getPhone(), "Phone");
        assertEquals(contact.getAddress(), "Address");

        Contact[] contacts = service.getContacts();
        assertEquals(contacts.length, 1);
    }
    
    // Ensure that ContactService can delete contacts provided its unique ID.
    @Test
    public void DeleteContact() {
        ContactService service = new ContactService();
        String id = service.addContact("First", "Last", "Phone", "Address");

        Contact[] contacts = service.getContacts();
        assertEquals(contacts.length, 1);

        service.delContact(id);

        contacts = service.getContacts();
        assertEquals(contacts.length, 0);

        Contact contact = service.getContact(id);
        assertNull(contact);
    }

    // Ensure that ContactService can update the contact's first name, and still obey the limit
    // and non-null rules.
    @Test
    public void SetFirstName() {
        ContactService service = new ContactService();
        String id = service.addContact("First", "Last", "Phone", "Address");

        Contact contact = service.getContact(id);
        contact.setFirstName("NEW");

        // Updating returned contact should update the contact within the service.
        Contact updated = service.getContact(id);
        assertEquals(contact.getFirstName(), updated.getFirstName());

        // Updating contacts through the ContactService should also set the first name.
        assertDoesNotThrow(
            () -> service.setFirstName(id, "NEWNEW")
        );
        assertEquals(contact.getFirstName(), "NEWNEW");

        // should not be able to set the first name to more than 10 chars.
        assertThrows(IllegalArgumentException.class,
                () -> service.setFirstName(id, "01234567890"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setFirstName("01234567890"));

        // should not be able to set the first name to null.
        assertThrows(IllegalArgumentException.class,
                () -> service.setFirstName(id, null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setFirstName(null));
    }

    // Ensure that ContactService can update the contact's last name, and still obey the limit
    // and non-null rules.
    @Test
    public void SetLastName() {
        ContactService service = new ContactService();
        String id = service.addContact("First", "Last", "Phone", "Address");

        Contact contact = service.getContact(id);
        contact.setLastName("NEW");

        // Updating returned contact should update the contact within the service.
        Contact updated = service.getContact(id);
        assertEquals(contact.getLastName(), updated.getLastName());

        // Updating contacts through the ContactService should also set the first name.
        assertDoesNotThrow(
            () -> service.setLastName(id, "NEWNEW")
        );
        assertEquals(contact.getLastName(), "NEWNEW");

        // should not be able to set the last name to more than 10 chars.
        assertThrows(IllegalArgumentException.class,
                () -> service.setLastName(id, "01234567890"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setLastName("01234567890"));

        // should not be able to set the last name to null.
        assertThrows(IllegalArgumentException.class,
                () -> service.setLastName(id, null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setLastName(null));
    }

    // Ensure that ContactService can update the contact's phone#, and still obey the limit
    // and non-null rules.
    @Test
    public void SetPhone() {
        ContactService service = new ContactService();
        String id = service.addContact("First", "Last", "Phone", "Address");

        Contact contact = service.getContact(id);
        contact.setPhone("NEW");

        // Updating returned contact should update the contact within the service.
        Contact updated = service.getContact(id);
        assertEquals(contact.getPhone(), updated.getPhone());

        // Updating contacts through the ContactService should also set the first name.
        assertDoesNotThrow(
            () -> service.setPhone(id, "NEWNEW")
        );
        assertEquals(contact.getPhone(), "NEWNEW");

        // should not be able to set the phone number to more than 10 chars.
        assertThrows(IllegalArgumentException.class,
                () -> service.setPhone(id, "01234567890"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone("01234567890"));

        // should not be able to set the phone number to null.
        assertThrows(IllegalArgumentException.class,
                () -> service.setPhone(id, null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setPhone(null));
    }

    // Ensure that ContactService can update the contact's address, and still obey the limit
    // and non-null rules.
    @Test
    public void SetAddress() {
        ContactService service = new ContactService();
        String id = service.addContact("First", "Last", "Phone", "Address");

        Contact contact = service.getContact(id);
        contact.setAddress("NEW");

        // Updating returned contact should update the contact within the service.
        Contact updated = service.getContact(id);
        assertEquals(contact.getAddress(), updated.getAddress());

        // Updating contacts through the ContactService should also set the first name.
        assertDoesNotThrow(
            () -> service.setAddress(id, "NEWNEW")
        );
        assertEquals(contact.getAddress(), "NEWNEW");

        // should not be able to set the address to more than 30 chars.
        assertThrows(IllegalArgumentException.class,
                () -> service.setAddress(id, "0123456789012345678901234567890"));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress("0123456789012345678901234567890"));

        // should not be able to set the phone number to null.
        assertThrows(IllegalArgumentException.class,
                () -> service.setAddress(id, null));
        assertThrows(IllegalArgumentException.class,
                () -> contact.setAddress(null));
    }
}
