/*
 * Eric Nunn
 * CPSC 5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package system;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import enums.Building;
import enums.FacultyType;
import enums.Quarter;
import enums.StudentType;
import enums.SubjectCode;
import enums.StudentProgram;
import exception.CourseNotFoundException;
import exception.DuplicateCourseException;
import exception.DuplicatePersonException;
import exception.DuplicateSectionException;
import exception.DuplicateSubjectException;
import exception.PersonNotFoundException;
import person.Student;
import person.Faculty;
import registration.Course;
import registration.Section;

/**
 * The RegistrationSystem class stores information about the school, including
 * the ability to add students, add faculty, add courses, and add prerequisite(s).
 * 
 * @author nunneric
 * @author ohsh
 */
public class RegistrationSystem {
	private List<Student> students;
	private List<Faculty> faculty;
	private Map<SubjectCode, String> subjects;
	private List<Course> courses;
	private List<Section> sections;
	
	/**
	 * Default constructor initializes RegistrationSystem into a valid state.
	 */
	public RegistrationSystem() { 
		students = new ArrayList<>();
		faculty = new ArrayList<>();
		subjects = new HashMap<>();
		courses = new ArrayList<>();
		sections = new ArrayList<>();
	} // end constructor
	
	/**
	 * Add a student to the student list collection.
	 * 
	 * @param firstName	The first name of the student
	 * @param lastName	The last name of the student
	 * @param type		The student type
	 * @param program	The student program	
	 * @param quarter	The start quarter of the student
	 * @param year		The start year of the student
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addStudent(String firstName, String lastName, 
							StudentType type, StudentProgram program,
							Quarter quarter, int year) 
							throws DuplicatePersonException {
		
		for (Student student : students) {
			// new student has same name as existing student
			if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName))
				throw new DuplicatePersonException();
		} // end for
		
		students.add(new Student(firstName, lastName, type, program, quarter, year));
	} // end addStudent
	
	/**
	 * Add a faculty to the faculty list collection.
	 * 
	 * @param firstName	The first name of the faculty
	 * @param lastName	The last name of the faculty
	 * @param type		The faculty type
	 * @param bldg		The building of the faculty office
	 * @param room		The (building) room of the faculty office
	 * @param email		The email of the faculty
	 * @throws DuplicatePersonException The person is already in the system
	 */
	public void addFaculty(String firstName, String lastName,
							FacultyType type, Building bldg, int room, String email) 
							throws DuplicatePersonException {
		
		// check if new faculty member is a duplicate
		for (Faculty faculty : faculty) {
			if (faculty.getFirstName().equals(firstName) && faculty.getLastName().equals(lastName))
				throw new DuplicatePersonException();
		} // end for
		
		faculty.add(new Faculty(firstName, lastName, type, bldg, room, email));
	} // end addFaculty
	
	/**
	 * Adds a subject to the subject list collection.
	 * (hint: use a Pair instead of creating a class)
	 * 
	 * @param code	The subject code
	 * @param desc	The subject description
	 * 
	 * @throws DuplicateSubjectException The subject is already in the system
	 */
	public void addSubject(SubjectCode code, String desc) 
							throws DuplicateSubjectException {
		// check for duplicate subject
		if (subjects.containsKey(code))
			throw new DuplicateSubjectException();
		
		subjects.put(code, desc);
	} // addSubject
	
	/**
	 * Adds a course to the course list collection.
	 * 
	 * @param code		The subject code of the course
	 * @param num		The course number of the course
	 * @param name		The course name
	 * @param creditNum	The number of the credits of the course
	 * @throws DuplicateCourseException	The course is already in the system 
	 */
	public void addCourse(SubjectCode code, int num, String name, 
							int creditNum) throws DuplicateCourseException {
		// create new course
		Course newCourse = new Course(code, num, name, creditNum);
		
		// check for duplicate course
		for (Course course : courses) {
			if (course.equals(newCourse))
				throw new DuplicateCourseException();
		} // end for

		// add course to list
		courses.add(newCourse);
	} // end addCourse
	
	/**
	 * Adds a prerequisite to an existing course in the course
	 * list collection.
	 * 
	 * @param code			The subject code of the course
	 * @param num			The course number of the course
	 * @param prereqCode	The subject code of the prerequisite
	 * 						to add to the course
	 * @param prereqNum		The course number of the prerequisite
	 * 						to add to the course
	 * @throws CourseNotFoundException The course was not found in the system
	 */
	public void addPrerequisite(SubjectCode code, int num, 
							SubjectCode prereqCode, int prereqNum) 
							throws CourseNotFoundException {
		
		Course course = null;
		Course prereq = null;
		
		// find course in list
		for (Course curr : courses) {
			if (curr.getCode().equals(code) && curr.getNum() == num) {
				course = curr;
			} // end if
		} // end for
		
		// if correct course wasn't found, throw exception
		if (course == null)
			throw new CourseNotFoundException();
		
		for (Course curr : courses) {
			if (curr.getCode().equals(prereqCode) && curr.getNum() == prereqNum) {
				prereq = curr;
			}
		}
		
		// if prereq wasn't found, throw exception
		if (prereq == null)
			throw new CourseNotFoundException();
		
		// add prereq object to course
		course.addPrereq(prereq);
	} // end addPrerequisite
	
	
	/**
	 * Adds a section to the section list collection.
	 * 
	 * @param code		 The subject code of the course
	 * @param courseNum	 The course number of the course
	 * @param sectionNum The section number for the course
	 * @param facultyLN	 The last name for the faculty teaching the course
	 * @param quarter	 The quarter that the course section is held 
	 * @param year		 The year that the course section is held
	 * @param cap		 The capacity of the course section
	 * @param bldg		 The building that the course section is held
	 * @param room		 The room that the course section is held
	 * @throws CourseNotFoundException The course was not found in the system
	 * @throws PersonNotFoundException The person was not found in the system
	 */
	public void addSection(SubjectCode code, int courseNum, int sectionNum, String firstName,
							String lastName, Quarter quarter, int year, 
							int cap, Building bldg, int room) 
							throws CourseNotFoundException, PersonNotFoundException, DuplicateSectionException {
		
		// get course
		Course course = null;
		for (Course curr : courses) {
			if (curr.getCode().equals(code) && curr.getNum() == courseNum) {
				course = curr;
			}
		} // end for
		
		// course not found
		if (course == null) {
			throw new CourseNotFoundException();
		} // end if
		
		// get instructor
		Faculty instructor = null;
		for (Faculty curr : faculty) {
			if (curr.getFirstName().equals(firstName) && curr.getLastName().equals(lastName)) {
				instructor = curr;
			} // end if
		} // end for
		
		// instructor not found
		if (instructor == null) {
			throw new PersonNotFoundException();
		} // end if
		
		
		// search for duplicate sections
		for (Section section : sections) {
			if (section.getCourse().getCode() == (code) && section.getCourse().getNum() == courseNum && section.getSectionNum() == sectionNum) {
				throw new DuplicateSectionException();
			} // end if
		} // end for
		
		// add section to list
		sections.add(new Section(course, sectionNum, instructor, quarter, year, cap, bldg, room));
	
	} // end addSection
	
	
	/**
	 * Returns a string with current state of all class fields.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		// faculty
		sb.append("Faculty:\n");
		for (Faculty faculty : faculty) {
			sb.append(faculty);
		} // end for
		
		// students
		sb.append("\nStudents:\n");
		for (Student student : students) {
			sb.append(student);
		} // end for
		
		// subjects
		sb.append("\nSubjects:\n");
		for (Map.Entry<SubjectCode,String> entry : subjects.entrySet()) {
			  sb.append(entry.getKey() + ": ");
			  sb.append(entry.getValue() + "\n");
		} // end for
		
		// courses
		sb.append("\nCourses:\n");
		for (Course course : courses) {
			sb.append(course);
		} // end for
		
		// sections
		sb.append("\nSections:\n");
		for (Section section : sections) {
			sb.append(section);
		} // end for
		
		return sb.toString();
	} // end toString
} // end RegistrationSystem
