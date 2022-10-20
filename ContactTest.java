package cs320;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactTest {

	@Test
	void FirstNameValid() {		
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setFirstName("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			}
		);
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setFirstName(null);
			}
		);
	}

	@Test
	void LastNameValid() {		
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setLastName("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			}
		);
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setLastName(null);
			}
		);
	}

	@Test
	void PhoneValid() {		
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setPhone("01234567890");
			}
		);
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setPhone(null);
			}
		);
	}

	@Test
	void AddressValid() {		
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setAddress("ABCDEFGHIJKLMNOPQRSTUVWXYZ01234");
			}
		);
		assertThrows(IllegalArgumentException.class,
			() -> {
				Contact contact = new Contact();
				contact.setAddress(null);
			}
		);
	}
}