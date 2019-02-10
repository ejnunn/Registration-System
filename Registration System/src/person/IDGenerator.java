/*
 * Eric Nunn
 * CPSC5011, Seattle University
 * This is free and unencumbered software released into the public domain.
 */
package person;

/**
 * The IDGenerator creates a unique SUID for each person that is created. The first person
 * created is asigned an ID of 0, and each time a person is created, the IDGenerator returns
 * an integer one larger than the last.
 * @author ericnunn
 *
 */
public class IDGenerator {
	private int suid;
	
	/**
	 * Constructor that initializes the IDGenerator into a valid state
	 * Sets suid to zero so the first ID assigned starts at zero.
	 */
	public IDGenerator() {
		suid = 0;
	} // end constructor
	
	/**
	 * Returns the next unique SUID number by incrementing the suid field
	 * by one each time this method is called.
	 * @return suid	unique integer suid number assigned to each person that is created
	 */
	public int getID() {
		return suid++;
	} // end getID
} // end SUIDGenerator
