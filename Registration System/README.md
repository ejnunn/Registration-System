I collaborated with Fang (Jenny) Yuan while working on this assignment. She and I asked each other questions about Java best practices, and 
clarification about assignment requirements, but did not talk in-depth about specific design implementations. Any similarities between our code are coincidental and were not specifically intended.


Is your solution fully working or not? 
	-	Yes my solution is fully working.

Justify any additional classes you included in your solution.
	-	I created a new class called IDGenerator in the person package because it simplifies the generation of unique SUID numbers.
		This class is used as a static field in the Person class. Every time a new person is created, the IDGenerator assigns them a unique SUID
		by incrementing it's internal SUID field by one. One way to improve this in the future is to create an SUID with a given number of digits,
		and by generating the SUIDs with more variety than incrementing each by one.

Did you work on the extra credit problem? Briefly describe any issues or explain any assumptions made.
	-	My class diagram shows the relationships between the major classes in this project. Both the Student and Faculty classes inherit from 
		the Person class. The Section class "has-a" Course, which means this is a composition relationship. The Section cannot exist without a Course.
		The Registration System class is associated with Student, Faculty, Course, and Section classes. It uses these classes but they have no
		knowledge of the Registration System itself. If the Registration System cannot access these other classes, it can still exist albeit with
		reduced functionality.
		I did not include the IDGenertor class because I only use it as a static field inside the Person class. I assume this is an aggregation
		relationship but am not entirely sure.

How much time did you spend on the assignment?
	-	I spent upwards of 20 hours on this assignment. It was not inherently difficult since most of the design was given to me, but there were
		many little issues that caused me to redo sections of the assignment. Initially I had included an ArrayList<Section> inside my Course class
		which caused me to have a confusing relationship between Course and Section. I also had trouble with certain exception handling because I did
		not see new versions of the Starter Code had been uploaded to GitHub. I do not know how to incorporate GitHub changes into my code easily, so
		I had to spend time finding which changes were made, and how to change my code accordingly.

Any feedback on the assignment?
	-	I enjoyed this assignment. At first it was confusing trying to wrap my head around all the class relationships, but once I got enough code
		written to let the Driver class print it to the console, I enjoyed playing around with the code and seeing how it effected the project as 
		a whole. I look forward to more projects like this, especially once they add more features and it looks more and more like a production
		quality product.