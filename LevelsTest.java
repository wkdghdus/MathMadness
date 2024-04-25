import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import java.io.*;

public class LevelsTest {


    @AfterClass
    public static void tearDownClass() {
        System.out.println("tearDownClass()");
        try{

            BufferedReader reader = new BufferedReader(new FileReader("files/StudentInfo.csv"));
            String newFile = "";
            String line;
            reader.readLine();  //skip the first line that was added in the setup class
            while ((line = reader.readLine()) != null) {
                newFile += line;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("files/StudentInfo.csv"));
            writer.write(newFile);

            reader.close();
            writer.close();

        }
        catch (Exception e){
            System.out.println("error");
        }
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("setUpClass()");
        try {

            BufferedReader reader = new BufferedReader(new FileReader("files/StudentInfo.csv"));
            String newFile = "TEST,1,2,3,4,1,2,3,4\n";
            String line;
            while ((line = reader.readLine()) != null) {
                newFile += line;
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter("files/StudentInfo.csv"));
            writer.write(newFile);

            reader.close();
            writer.close();

        } catch (Exception e) {
            System.out.println("error");
        }
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
    public void testGetLevelsUnlocked() {

        setUp();
        
        Levels levels = new Levels(1, "TEST");
        int[] levelsUnlocked = levels.getLevelsUnlocked();
        boolean test1 = levelsUnlocked[0] == 1;
        boolean test2 = levelsUnlocked[1] == 2;
        boolean test3 = levelsUnlocked[2] == 3;
        boolean test4 = levelsUnlocked[3] == 4;
        boolean testTtl = test1 && test2 && test3 && test4;
        
        assertTrue(testTtl);
        fail("failed get levels unlocked test");
        
        tearDown();
        
    }

    @Test
    public void testGetScore() {

        setUp();

        Levels levels = new Levels(1, "TEST");
        
        boolean test1 = levels.getScore(0) == 1;
        boolean test2 = levels.getScore(1) == 2;
        boolean test3 = levels.getScore(2) == 3;
        boolean test4 = levels.getScore(3) == 4;
        
        assertTrue(test1 && test2 && test3 && test4);

        fail("failed get score test");

        tearDown();


    }

    @Test
    public void testSetLevelsUnlocked() {
        //this method will test setScore and updateFile as well

        setUp();

        Levels levels = new Levels(1, "TEST");
        levels.setLevelsUnlocked(1, 3);
        int[] levelsUnlocked = levels.getLevelsUnlocked();
        boolean test1 = levelsUnlocked[1] == 3;
        boolean test2 = levels.getScore(1) == 300;
        boolean test3 = false;
        boolean test4 = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("files/StudentInfo.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("TEST")) {
                    String[] lineArray = line.split(",");
                    test3 = lineArray[2].equals("3");
                    test4 = lineArray[6].equals("300");
                }
                reader.close();
            }
        } catch (Exception e) {
            System.out.println("failed to read file in set levels unlocked test");
        }


        boolean testTtl = test1 && test2 && test3 && test4;

        assertTrue(testTtl);

        fail("failed set levels unlocked test");

        tearDown();

    }

}
