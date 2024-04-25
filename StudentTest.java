import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Minh Pham
 *
 */
class StudentTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test of getLevelProgression method, of class Student.
	 * 
	 * The expected result is hard-coded according to the StudentInfo.csv file at the time
	 * of writing. So the test might fail depending on the update of the StudentInfo.csv file
	 */
	@Test
	void testGetLevelProgression() throws IOException {
		System.out.println("getLevelProgression");
		Student instance = new Student("atmiya", "atmiyapatel");
		int expResult = 5;
		int result = instance.getLevelProgression(0);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getLevelScore method, of class Student.
	 * 
	 * The expected result is hard-coded according to the StudentInfo.csv file at the time
	 * of writing. So the test might fail depending on the update of the StudentInfo.csv file
	 */
	@Test
	void testGetLevelScore() throws IOException {
		System.out.println("getLevelScore");
		Student instance = new Student("atmiya", "atmiyapatel");
		int expResult = 300;
		int result = instance.getLevelScore(0);
		assertEquals(expResult, result);
	}
}
