// import static org.junit.jupiter.api.Assertions.*;

// import java.io.IOException;

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


import java.io.IOException;

/**
 * 
 * @author Minh Pham
 *
 */

class AccountTest {

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
	 * Test of getUsername method, of class Account
	 */
	@Test
	void testGetUsername() throws IOException {
		System.out.println("getUsername");
		Account instance = new Account("atmiya", "atmiyapatel");
		String expResult = "atmiya";
		String result = instance.getUsername();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getPassword method, of class Account
	 */
	@Test
	void testGetPassword() throws IOException {
		System.out.println("getPassword");
		Account instance = new Account("atmiya", "atmiyapatel");
		String expResult = "atmiyapatel";
		String result = instance.getPassword();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of logInLabel method, of class Account
	 */
	@Test
	void testLogInLabel() throws IOException {
		System.out.println("logInLabel");
		Account instance = new Account("atmiya", "atmiyapatel");
		String expResult = "Successfully logged in.";
		String result = instance.logInLabel(1);
		assertEquals(expResult, result);
		
		expResult = "Incorrect password.";
		result = instance.logInLabel(2);
		assertEquals(expResult, result);
		
		expResult = "Username does not exist.";
		result = instance.logInLabel(3);
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getConfirmationMessage method, of class Account
	 */
	@Test
	void testGetConfirmationMessage() throws IOException {
		System.out.println("getConfirmationMessage");
		Account instance = new Account("atmiya", "atmiyapatel");
		String expResult = "Successfully logged in.";
		String result = instance.getConfirmationMessage();
		assertEquals(expResult, result);
	}
	
	/**
	 * Test of getSuccessfulLogin method, of class Account
	 */
	@Test
	void testGetSuccessfulLogin() throws IOException {
		System.out.println("getSuccessfulLogin");
		Account instance = new Account("atmiya", "atmiyapatel");
		boolean expResult = true;
		boolean result = instance.getSuccessfulLogin();
		assertEquals(expResult, result);
	}
}
