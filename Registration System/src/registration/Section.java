/*
 * Eric Nunn
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package registration;

import enums.Building;
import enums.Quarter;
import person.Faculty;

/**
 * The Section class holds information about a course section.
 * 
 * For example, CPSC 5011-01: Object-Oriented Concepts
 * - course: CPSC 5011
 * - section: 02
 * - instructor: Sheila Oh
 * - quarter/year: FQ18
 * - capacity: 30
 * - building/room: LEML 122
 * 
 * @author nunneric
 */
public class Section {	
	private Course course;
	private int section;
	private Faculty instructor;
	private Quarter quarter;
	private int year;
	private int cap;
	private Building bldg;
	private int room;
	
	/**
	 * Constructor that initializes the Section class into a valid state.
	 * @param course	 The course associated with the section
	 * @param section	 The section number for the course
	 * @param instructor The faculty instructor teaching the course
	 * @param quarter	 The quarter that the course section is held 
	 * @param year		 The year that the course section is held
	 * @param cap		 The capacity of the course section
	 * @param bldg		 The building that the course section is held
	 * @param room		 The room that the course section is held
	 */
	public Section(Course course, int section, Faculty instructor, Quarter quarter, 
					int year, int cap, Building bldg, int room) {
		this.course = course;
		this.section = section;
		this.instructor = instructor;
		this.quarter = quarter;
		this.year = year;
		this.cap = cap;
		this.bldg = bldg;
		this.room = room;
	} // end constructor
	
	/**
	 * Returns the course associated with this section
	 * @return course	The course related to this section
	 */
	public Course getCourse() {
		return course;
	} // end getCourse
	
	/**
	 * Returns this class's section number.
	 * @return section	The section number for the course
	 */
	public Integer getSectionNum() {
		return section;
	} // end getSectionNum

	
	/**
	 * Returns a String of the current state of all fields in this section
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Course: " + course.getCode() + course.getNum() + " ");
		sb.append("Section: " + section + " ");
		sb.append("Instructor: " + String.format("%-16s", instructor.getFirstName() + " " + instructor.getLastName()) + " ");
		sb.append("Quarter/Year: " + quarter + (year % 100) + " ");
		sb.append("Capacity: " + cap + " ");
		sb.append("Building/Room: " + bldg + " " + room + " ");
		
		sb.append("\n");
		return sb.toString();
	} // end toString
} // end Section
