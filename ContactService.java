package cs320;

import java.security.InvalidKeyException;
import java.util.HashMap;
import java.util.UUID;

public class ContactService {

    private HashMap<String, Contact> contacts = new HashMap<String, Contact>();

    /**
     * Add contact to ContactService
     * 
     * @param fname   Contact's first name
     * @param lname   Contact's last name
     * @param phone   Contact's phone number
     * @param address Contact's address
     * @return
     */
    public String addContact(String fname, String lname, String phone, String address) {
        String id = getUniqueId();
        Contact contact = new Contact(id, fname, lname, phone, address);
        contacts.put(id, contact);
        return id;
    }

    /**
     * Delete contact from ContactService
     * 
     * @param id Contact's id
     */
    public void delContact(String id) {
        if (contacts.containsKey(id)) {
            contacts.remove(id);
        }
    }

    /**
     * Get contact from ContactService
     * 
     * @param id Contact's unique id
     * @return Contact or null if unique id nonexistent
     */
    public Contact getContact(String id) {
        return contacts.get(id);
    }

    /**
     * Get contacts from ContactService
     * 
     * @return all contacts in an array
     */
    public Contact[] getContacts() {
        return contacts.values().toArray(new Contact[0]);
    }

    /**
     * Sets first name, throw exception if unique id not found
     * @param id
     * @param fname
     * @throws InvalidKeyException
     */
    public void setFirstName(String id, String fname) throws InvalidKeyException {
        if (!contacts.containsKey(id)) {
            throw new InvalidKeyException();
        }
        Contact contact = contacts.get(id);
        contact.setFirstName(fname);
    }

    /**
     * Set last name, throw exception if unique id not found
     * @param id
     * @param lname
     * @throws InvalidKeyException
     */
    public void setLastName(String id, String lname) throws InvalidKeyException {
        if (!contacts.containsKey(id)) {
            throw new InvalidKeyException();
        }
        Contact contact = contacts.get(id);
        contact.setLastName(lname);
    }

    /**
     * Set address, throw exception if address not found
     * @param id
     * @param address
     * @throws InvalidKeyException
     */
    public void setAddress(String id, String address) throws InvalidKeyException {
        if (!contacts.containsKey(id)) {
            throw new InvalidKeyException();
        }
        Contact contact = contacts.get(id);
        contact.setAddress(address);
    }

    /**
     * Set phone, throw exception if not found
     * @param id
     * @param phone
     * @throws InvalidKeyException
     */
    public void setPhone(String id, String phone) throws InvalidKeyException {
        if (!contacts.containsKey(id)) {
            throw new InvalidKeyException();
        }
        Contact contact = contacts.get(id);
        contact.setPhone(phone);
    }

    /**
     * Generates random UUID, removes hyphen from text format, takes 10 characters from 
     * left of string. Generates until unique ID is found that has not been used.
     * @return
     */
    private String getUniqueId() {
        String uniqueId = "";
        do {
            uniqueId = UUID.randomUUID()
                    .toString()
                    .replace("-", "")
                    .substring(0, 10);
        } while (contacts.containsKey(uniqueId));
        return uniqueId;
    }
}
