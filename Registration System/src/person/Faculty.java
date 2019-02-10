/*
 * Eric Nunn
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;

import enums.Building;
import enums.FacultyType;

/**
 * The Faculty class holds information about a faculty member.
 * 
 * - first name: first name of the student
 * - last name: last name of the student
 * - suid: Seattle U identification number
 * - status: the status of the faculty (see PersonStatus enum)
 * - faculty type: the type of faculty (see FacultyType enum)
 * - office: includes building (i.e. ENGR) and room number (i.e 504)
 * - email: the school (i.e. SU) email address
 * 
 * @author nunneric
 */
public class Faculty extends Person {
	// first name, last name, SUID, status, faculty type, office (see building), email
	private FacultyType type;
	private String office;
	
	/**
	 * Default constructor that initializes a Faculty member without setting their type, bldg, room, or email.
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 */
	public Faculty(String firstName, String lastName) {
		super(firstName, lastName);
		this.type = null;
		this.office = null;
	} // end default constructor
	
	/**
	 * Constructor that initializes all Faculty fields.
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 * @param type		The faculty type which has to be one of the FacultyType enums
	 * @param bldg		The building in which the faculty has their office
	 * @param room		The room of the building that the faculty has their office
	 * @param email		The email address of the faculty
	 */
	public Faculty(String firstName, String lastName, FacultyType type, Building bldg, int room, String email) {
		super(firstName, lastName);
		this.type = type;
		this.office = "" + bldg + room;
		this.email = email;
	} // end constructor
	
	/**
	 * Returns a string of the current state of all Faculty fields.
	 * @return a string of all the class fields
	 */
	@Override
	public String toString() {
		return	"First Name: " + String.format("%-10s", firstName) + " " +
				"Last Name: " + String.format("%-10s", lastName) + " " +
				"SUID: " + String.format("%-4s", suid) + " " +
				"Status: " + String.format("%-10s", status) + " " +
				"Faculty Type: " + String.format("%-13s", type) + " " +
				"Office: " + String.format("%-8s", office) + " " +
				"Email: " + email + "\n";
	} // end toString
} // end Faculty
