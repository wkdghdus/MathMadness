import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class QuestionTest {
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass()");
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass()");
        
    }

    @Before
    public void setUp() {
        System.out.println("setUp()");

    }

    @After
    public void tearDown() {
        System.out.println("tearDown()");
    }


    @Test
    public void testCreateAdditionQuestion() {
        setUp();
        Question question = new Question(0, 1);
        String[] questionArray = question.getQuestion().split(" ");

        //check if the question is in the correct format
        boolean test1 = questionArray[1].equals("+");
        //check if the answer is correct
        boolean test2 = Integer.parseInt(questionArray[0]) + Integer.parseInt(questionArray[2]) == question.getAnswer();
        boolean testTtl = test1 && test2;
        
        assertTrue(testTtl);

        fail("failed addition quetion test");
        tearDown();
    }

    @Test
    public void testCreateSubtractionQuestion() {
        setUp();
        Question question = new Question(1, 1);
        String[] questionArray = question.getQuestion().split(" ");

        //check if the question is in the correct format
        boolean test1 = questionArray[1].equals("-");
        //check if the answer is correct
        boolean test2 = Integer.parseInt(questionArray[0]) - Integer.parseInt(questionArray[2]) == question.getAnswer();
        boolean testTtl = test1 && test2;

        assertTrue(testTtl);
        
        fail("failed subtraction quetion test");
        tearDown();
    }

    @Test
    public void testCreateMultiplicationQuestion() {
        setUp();
        Question question = new Question(2, 1);
        String[] questionArray = question.getQuestion().split(" ");

        //check if the question is in the correct format
        boolean test1 = questionArray[1].equals("X");
        //check if the answer is correct
        boolean test2 = Integer.parseInt(questionArray[0]) * Integer.parseInt(questionArray[2]) == question.getAnswer();
        boolean testTtl = test1 && test2;

        assertTrue(testTtl);
        
        fail("failed multiplication quetion test");
        tearDown();

    }

    @Test
    public void testCreateDivisionQuestion() {
        setUp();
        Question question = new Question(3, 1);
        String[] questionArray = question.getQuestion().split(" ");

        //check if the question is in the correct format
        boolean test1 = questionArray[1].equals("/");
        //check if the answer is correct
        boolean test2 = Integer.parseInt(questionArray[0]) / Integer.parseInt(questionArray[2]) == question.getAnswer();
        boolean testTtl = test1 && test2;

        assertTrue(testTtl);

        fail("failed division quetion test");
        tearDown();
    }

    @Test
    public void testInvalidGameMode() {

        setUp();

        // Test case for an invalid game mode
        Question question = new Question(4, 1);
        // Add your assertions here to verify the behavior when an invalid game mode is provided
        assertEquals("Invalid game mode", question.getQuestion());

        tearDown();

    }

    @Test
    public void testGenerateOptions() {
        
        setUp();

        Question question = new Question(0, 1);
        int[] options = question.generateOptions();
        
        //check validity of the options
        boolean test1 = options[0] == question.getAnswer();
        boolean test2 = options[1] != question.getAnswer();
        boolean test3 = options[2] != question.getAnswer();
        boolean test4 = options[1] > 0;
        boolean test5 = options[2] > 0;
        
        boolean testTtl = test1 && test2 && test3 && test4 && test5;

        assertTrue(testTtl);

        tearDown();


    }

    @Test
    public void testGetAnswer() {
        //tested with other methods
    }

    @Test
    public void testGetQuestion() {
        //tested with other methods
    }

    @Test
    public void testSetAnswer() {
        Question question = new Question(0, 1);
        int ogAnswer = (int)question.getAnswer();
        question.setAnswer(ogAnswer + 1);
        assertEquals(ogAnswer+1, question.getAnswer());
    }

    @Test
    public void testSetQuestion() {
        Question question = new Question(0, 1);
        question.setQuestion("new question");
        assertEquals("new question", question.getQuestion());
    }
}