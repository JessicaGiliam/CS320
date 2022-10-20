package cs320;

public class Contact {

	private String Id;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	public Contact() {
	}

	public Contact(String id, String fName, String lName, String phone, String address) {
		setId(id);
		setFirstName(fName);
		setLastName(lName);
		setPhone(phone);
		setAddress(address);
	}
	private void setId(String id){
		if ((id == null) || (id.length() > 10)) {
			throw new IllegalArgumentException("Must Not Be Null, Requires 10 or less Characters");		
		}
		Id = id;
	}

	/*Get unique Id. */
	public String getId() {
		return Id;
	}
	/*Get contact's first name. */
	public String getFirstName() {
		return firstName;
	}
	/*Set contact's first name. */
	public void setFirstName(String name) {
		if ((name == null) || (name.length() > 10)) {
			throw new IllegalArgumentException("Must Not Be Null, Requires 10 or less Characters");		
		}
		firstName = name;
	}
	/*Get contact's last name. */
	public String getLastName() {
		return lastName;
	}
	/*Set contact's last name, restricted to 10 char or less and not null. */
	public void setLastName(String name) {
		if ((name == null) || (name.length() > 10)) {
			throw new IllegalArgumentException("Must Not Be Null, Requires 10 or less Characters");		
		}
		lastName = name;
	}
	/*Get contact's phone number. */
	public String getPhone() {
		return phone;
	}
	/*Set contact's phone number, restricted to 10 char or less and not null */
	public void setPhone(String number) {
		if ((number == null) || (number.length() > 10)) {
			throw new IllegalArgumentException("Must Not Be Null, Requires 10 or less Characters");		
		}
		phone = number;
	}
	/*Get contact's address. */
	public String getAddress() {
		return address;
	}
	/*Set contact's address, restricted to 30 char or less and not null. */
	public void setAddress(String residence) {
		if ((residence == null) || (residence.length() > 30)) {
			throw new IllegalArgumentException("Must Not Be Null, Requires 30 or less Characters");		
		}
		address = residence;
	}
}