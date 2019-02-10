/*
 * Eric Nunn
 * CPSC5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package registration;

import java.util.List;
import java.util.ArrayList;
import enums.SubjectCode;

/**
 * The Course class holds information about a course.
 * 
 * For example, CPSC 5011: Object-Oriented Concepts
 * - subject code: CPSC
 * - course number: 5011
 * - course name: Object-Oriented Concepts
 * - credit number: 3
 * - prerequisite(s): CPSC 5003 (can have multiple prerequisites or none)
 * 
 * @author nunneric
 */
public class Course {
	private SubjectCode code;
	private int courseNum;
	private String name;
	private int creditNum;
	private List<Course> prereqs;
	
	/**
	 * 
	 * @param code		The subject code of the course
	 * @param courseNum	The course number of the course
	 * @param name		The course name
	 * @param creditNum The number of the credits of the course
	 */
	public Course(SubjectCode code, int courseNum, String name, 
					int creditNum) {
		this.code = code;
		this.courseNum = courseNum;
		this.name = name;
		this.creditNum = creditNum;
		this.prereqs = new ArrayList<>();
	} // end constructor
	
	/**
	 * Adds a new prerequisite to the prereq list.
	 * @param prereq The prereq's code and number
	 */
	public void addPrereq(Course prereq) {
		prereqs.add(prereq);
	} // end addPrereq
	
	/**
	 * Returns the course's subject code
	 * @return code	SubjectCode of this course
	 */
	public SubjectCode getCode() {
		return code;
	} // end getCode

	/**
	 * Returns the course's number,
	 * @return courseNum	This course's number
	 */
	public int getNum() {
		return courseNum;
	} // end getNum
	
	/**
	 * Returns a String of the current state of all of this course's fields.
	 * @return	this course's current state
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Course code: " + code + " ");
		sb.append("Course Number: " + courseNum + " ");
		sb.append("Name: " + String.format("%-45s", name) + " ");
		sb.append("Credits: " + creditNum + " ");
		sb.append("Prereqs: ");
		String prefix = "";
		for (Course prereq : prereqs) {
			sb.append(prefix);
			prefix = ", ";
			sb.append("" + prereq.getCode() + prereq.getNum());
		} // end for
		
		sb.append("\n");
		return sb.toString();
	} // end toString

} // end Course
