// import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 * 
 * @author Minh Pham
 *
 */

class InstructorTest {

	@BeforeClass
	static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	static void tearDownAfterClass() throws Exception {
	}

	@Before
	void setUp() throws Exception {
	}

	@After
	void tearDown() throws Exception {
	}

	
	/**
	 * Test of getStudentMetrics method, of class Instructor
	 * 
	 * The expected result is hard-coded according to the StudentInfo.csv file at the time
	 * of writing. So the test might fail depending on the update of the StudentInfo.csv file
	 */
	@Test
	void getStudentMetrics() throws IOException {
		System.out.println("getStudentMetrics");
		Instructor instance = new Instructor("IamAnInstructor");
		String[] expResult = {"atmiya", "atmiyapatel", "1", "1", "1", "1", "0", "0", "0", "0"};
		String[] result = instance.getStudentMetrics("atmiya");
		assertArrayEquals(expResult, result);
	}
	
	/**
	 * Test of checkIfInstructorPassCorrect method, of class Instructor
	 */
	@Test
	void testCheckIfInstructorPassCorrect() throws IOException {
		System.out.println("ifInstructorPassCorrect");
		Instructor instance = new Instructor("IamAnInstructor");
		boolean expResult = true;
		boolean result = instance.checkIfInstructorPassCorrect("IamAnInstructor");
		assertEquals(expResult, result);
		
		expResult = false;
		result = instance.checkIfInstructorPassCorrect("IamNotAnInstructor");
		assertEquals(expResult, result);
	}

}
