import java.util.*;
import java.io.*;


public class Customer {

	private String firstName;
	private String lastName;
	private String gender;
	private String status;
	private String location;
	private String contact;
	
	public Customer() {
		firstName = "";
		lastName = "";
		gender = "";
		status = "";
		location = "";
		contact = "";
	}
	
	public void setCustomer(String newFirstName, String newLastName, String newGender, String newStatus, String newLocation, String newContact){
		firstName = newFirstName;
		lastName = newLastName;
		gender = newGender;
		status = newStatus;
		location = newLocation;
		contact = newContact;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFullName() {
		return getFirstName() + " " + getLastName();
	}
	
	public String getGender() {
		return gender;
	}
	
	public String getStatus() {
		return status;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String getContact() {
		return contact;
	}
}
