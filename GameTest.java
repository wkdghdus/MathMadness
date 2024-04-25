import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class GameTest {


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
    public void testGetQuestionBank() {
        setUp();
        Game game = new Game(0, 0);
        Question[] questionBank = game.getQuestionBank();
        boolean test1 = questionBank.length == 5;   //test the length
        boolean test2 = false;  //to check if the question bank contains correct type of question
        boolean test3 = true;   //to check if the question bank is all not null
        for (int i = 0; i < questionBank.length; i++) {

            try{

                test2 = questionBank[i].getQuestion().contains("+");

                if (!test2){
    
                    break;
    
                }

            } catch (NullPointerException e) {
                //if the question bank is null, then the test fails
                test3 = false;
                break;
            }
           
        }

        assertTrue(test1 && test2 && test3);

        tearDown();

    }

    @Test
    public void testGetRemainingLives() {
        //this test also tests deductRemainingLives
        setUp();
        Game game = new Game(0, 0);
        boolean test1 = game.getRemainingLives() == 3;
        game.deductRemainingLives();
        boolean test2 = game.getRemainingLives() == 2;
        boolean testTtl = test1 && test2;
        assertTrue(testTtl);
        tearDown();

    }

    @Test
    public void testGetSetSubLevel() {

        Game game = new Game(0, 0);
        boolean test1 = 0 == game.getSubLevel();
        game.setSubLevel(1);
        boolean test2 = 1 == game.getSubLevel();
        assertTrue(test1 && test2);

    }

    @Test
    public void testPassedLevel() {

        Game game = new Game(0, 0);
        game.incrementCorrectAnswers();
        boolean test1 = game.passedLevel() == false;
        for (int i = 0; i < 5; i++) {
            game.incrementCorrectAnswers();
        }
        boolean test2 = game.passedLevel();
        boolean testTtl = test1 && test2;
        assertTrue(testTtl);

    }

}
