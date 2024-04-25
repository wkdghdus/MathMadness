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

class SignUpTest {
    @BeforeClass
    static void setUpBeforeClass() throws Exception {
        System.out.println("setUpClass()");
    }

    @AfterClass
    static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownClass()");
    }

    @Before
    void setUp() throws Exception {
        System.out.println("setUp()");
    }

    @After
    void tearDown() throws Exception {
        System.out.println("tearDown()");
    }
    @Test
    void testUsernameTooShort() throws IOException {
        SignUp signUp = new SignUp("", "validPassword123", "validPassword123");
        assertEquals("Username must have at least 1 character.", signUp.getConfirmationMessage());
    }
    @Test
    void testPasswordTooShort() throws IOException {
        SignUp signUp = new SignUp("validUsername", "short", "short");
        assertEquals("Password is less than 8 characters. Try again.", signUp.getConfirmationMessage());
    }
    @Test
    void testPasswordsDoNotMatch() throws IOException {
        SignUp signUp = new SignUp("validUsername", "validPassword123", "differentPassword123");
        assertEquals("Passwords do not match. Try again.", signUp.getConfirmationMessage());
    }

    @Test
    void testUsernameAlreadyExists() throws IOException {
        // First, create a user to ensure the username is already taken
        new SignUp("existingUser", "validPassword123", "validPassword123");

        // Then, try to create another user with the same username
        SignUp signUp = new SignUp("existingUser", "otherValidPassword123", "otherValidPassword123");
        assertEquals("Username already exists, re-enter a new one.", signUp.getConfirmationMessage());
    }
    @Test
    void testSuccessfulSignUp() throws IOException {
        System.out.println("Testing successful account creation.");
        SignUp signUp = new SignUp("newUser", "validPassword123", "validPassword123");
        assertEquals("Account successfully created.", signUp.getConfirmationMessage());
    }
}
