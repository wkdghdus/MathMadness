import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntegrationTesting {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test of SignUp, Account, Student, and Instructor class.
	 */
	@Test
	void testAccountSignUp() throws IOException {
		// Testing the signing up and logging in process is running properly
		SignUp newAccount = new SignUp("dummytest", "password", "password");
		Student newStudent = new Student("dummytest", "password");
		String expConfirmMsg = "Successfully logged in.";
		String confirmMsg = newStudent.getConfirmationMessage();
		assertEquals(expConfirmMsg, confirmMsg);
		
		// Testing Instructor class interaction with the Student class
		Instructor newInstructor = new Instructor("IamAnInstructor"); 
		String[] metric = {"dummytest","password","","","","","","","",""};
		
		for (int i = 0; i < 4; i++) {
			metric[i+2] = String.valueOf(newStudent.getLevelProgression(i));
			metric[i+6] = String.valueOf(newStudent.getLevelScore(i));
		}
		
		String[] expMetric = newInstructor.getStudentMetrics("dummytest");
		assertArrayEquals(expMetric, metric);
	}
	
	/**
	 * Test of Question and Game class.
	 */
	@Test
	void testQuestionAndGame() {
		int[] expAnswer = new int[5];
		int[] answer = new int[5];
		
		// Create a game of level 1, addition mode
		Game addGame = new Game(1, 0);
		for (int i = 0; i < 5; i++) {
			Question newQuest = addGame.getQuestionBank()[i];
			String[] questionSplit = newQuest.getQuestion().split(" ");
			expAnswer[i] = Integer.parseInt(questionSplit[0]) + Integer.parseInt(questionSplit[2]);
			answer[i] = newQuest.getAnswer();
		}
		assertArrayEquals(expAnswer, answer);

		// Create a game of level 2, subtraction mode
		Game subGame = new Game(2, 1);
		for (int i = 0; i < 5; i++) {
			Question newQuest = subGame.getQuestionBank()[i];
			String[] questionSplit = newQuest.getQuestion().split(" ");
			expAnswer[i] = Integer.parseInt(questionSplit[0]) - Integer.parseInt(questionSplit[2]);
			answer[i] = newQuest.getAnswer();
		}
		assertArrayEquals(expAnswer, answer);
		
		// Create a game of level 3, multiplication mode
		Game mulGame = new Game(3, 2);
		for (int i = 0; i < 5; i++) {
			Question newQuest = mulGame.getQuestionBank()[i];
			String[] questionSplit = newQuest.getQuestion().split(" ");
			expAnswer[i] = Integer.parseInt(questionSplit[0]) * Integer.parseInt(questionSplit[2]);
			answer[i] = newQuest.getAnswer();
		}
		assertArrayEquals(expAnswer, answer);
		
		// Create a game of level 4, division mode
		Game divGame = new Game(4, 3);
		for (int i = 0; i < 5; i++) {
			Question newQuest = divGame.getQuestionBank()[i];
			String[] questionSplit = newQuest.getQuestion().split(" ");
			expAnswer[i] = (int)(Integer.parseInt(questionSplit[0]) / Integer.parseInt(questionSplit[2]));
			answer[i] = newQuest.getAnswer();
		}
		assertArrayEquals(expAnswer, answer);
	}

}