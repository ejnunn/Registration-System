/*
 * Eric Nunn
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;

import enums.*;

/**
 * A Person class holds the name, SUID, and other information that will be inherited by either Students or Faculty.
 * @author ericnunn
 * @version 1.0
 */
public class Person {
	protected String firstName;
	protected String lastName;
	protected int suid;
	protected static IDGenerator idGenerator = new IDGenerator();
	protected PersonStatus status;
	protected String email;
	
	/**
	 * Constructor initializes Person class into a valid state. 
	 * @param firstName	The first name of the person
	 * @param lastName	The last name of the person
	 */
	public Person(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.suid = idGenerator.getID();
		this.status = PersonStatus.ACTIVE;
	} // end constructor
	
	/**
	 * Returns the first name of the person
	 * @return firstName	The first name of the person
	 */
	public String getFirstName() {
		return firstName;
	} // end getFirstName
	
	/**
	 * Returns the last name of the person
	 * @return lastName	The last name of the person
	 */
	public String getLastName() {
		return lastName;
	} // end getLastName
}
