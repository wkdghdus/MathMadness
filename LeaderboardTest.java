// import static org.junit.jupiter.api.Assertions.*;

// import java.io.IOException;
// import org.junit.jupiter.api.AfterAll;
// import org.junit.jupiter.api.AfterEach;
// import org.junit.jupiter.api.BeforeAll;
// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LeaderboardTest {
    private static Leaderboard leaderboard;
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.out.println("setUpClass()");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("tearDownClass()");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp()");
        leaderboard = new Leaderboard("files/StudentInfo.csv");
        
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown()");
    }

    @Test
    public void testHighScoresReturnsTop5() throws IOException {
        String[][] expected = {
                {"atm", "ben", "atmiya", "Instructor", "Debugger"}, // Usernames in descending order of AddScore
                {"12", "11", "6", "5", "5"} // Corresponding AddScores
        };

        String[][] actual = leaderboard.highScores(6); // 6 is the index for the "AddScore" column

        assertArrayEquals(expected, actual, "The top 5 AddScores should be correctly identified and returned in descending order.");
    }
}


