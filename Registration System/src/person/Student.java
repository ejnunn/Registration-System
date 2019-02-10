/*
 * Eric Nunn
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;

import enums.Quarter;
import enums.StudentProgram;
import enums.StudentType;
import enums.StudentYear;

/**
 * The Student class holds information about a student. 
 * 
 * - first name: first name of the student
 * - last name: last name of the student
 * - suid: Seattle U identification number
 * - status: the status of the student (see PersonStatus enum)
 * - student type: a student can only be assigned a single student type
 *   (see StudentType enum)
 * - student program: a student can only be assigned to a single program at 
 *   a point of time, but can switch from one program to another (i.e. when 
 *   they've graduated from a program (see StudentProgram enum)
 * - student year: only relevant for undergraduates (see StudentYear enum)
 * - faculty advisor: students are assigned a faculty advisor, but may switch 
 *   advisors (i.e. faculty leaves or on sabbatical); may not be assigned an
 *   advisor for a period of time when first enrolled as a student
 * - start term: associated with the quarter and year a student starts a
 *   particular program; for example, a single student may start the CERT in 
 *   RQ17 and then continue the MSCS in FQ18 (see Quarter enum)
 * - email: the school (i.e. SU) email address
 * 
 * @author 
 */
public class Student extends Person {
	private StudentType type;
	private StudentProgram program;
	private StudentYear studentYear;
	private String startTerm;
	private Faculty facultyAdvisor;
	
	/**
	 * Default constructor. Calls Person's constructor.
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 */
	public Student(String firstName, String lastName) {
		super(firstName, lastName);
	} // end default constructor
	
	/**
	 * Constructor that calls Person's constructor, then initializes all Student specific fields.
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 * @param type		The student's type
	 * @param program	The program that the student is in
	 * @param quarter	The student's current quarter in their program
	 * @param year		The student's year in their undergrad program, otherwise null if a grad student
	 */
	public Student(String firstName, String lastName, StudentType type, StudentProgram program, Quarter quarter, int year) {
		super(firstName, lastName);
		this.email = firstName + lastName + "@seattleu.edu";
		this.type = type;
		this.program = program;
		this.startTerm = "" + quarter + (year % 100);
		if (this.type.equals(StudentType.UNDERGRAD))
			this.studentYear = StudentYear.FRESHMAN;
		else
			this.studentYear = null;
		this.facultyAdvisor = null;
	} // end constructor

	/**
	 * Returns a String of the current state of all of this student's fields.
	 * @return	this student's current state
	 */
	public String toString() {
		return	"First Name: " + String.format("%-10s", firstName) + " " +
				"Last Name: " + String.format("%-10s", lastName) + " " +
				"SUID: " + String.format("%-4s", suid) + " " +
				"Status: " + String.format("%-10s", status) + " " +
				"Student Type: " + String.format("%-16s", type) + " " +
				"Student Program: " + String.format("%-10s", program) + " " +
				"Student Year: " + String.format("%-8s", studentYear) + " " +
				"Faculty Advisor: " + facultyAdvisor + " " +
				"Start Term: " + startTerm + " " +
				"Email: " + email + "\n";
	} // end toString
} // end Student
