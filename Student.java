import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Student account that extends from the Account class for storing student scores and progression
 * <br><br>
 * Scores are stored with the {@link readFile} method and can be retrieved from the {@link getLevelProgression}
 * and {@link getLevelScore} methods
 * 
 * @author Minh Pham
 * @author Atmiya Patel
 *
 */
public class Student extends Account{
	/** The student's level progression */
    private int[] levelProgression = new int[4];
    /** The student's score for every level */
    private int[] levelScore = new int[4];
    
    /**
     * Student constructor. Create a new Student object.
     * 
     * @param username the account's username
     * @param password the account's password
     * @throws IOException if the file doesn't exist
     */
    public Student(String username, String password) throws IOException {
    	super(username, password);
    }
    
    /**
     * Get the student's progression of a specific mode. 
     * 0 is addition, 1 is subtraction, 2 is multiplication, 3 is division
     * 
     * @param mode the mode to get the level progression from
     * @return the student's progression on a mode
     * @throws IOException if the file doesn't exist
     * @see readFile
     */
    public int getLevelProgression(int mode) throws IOException{
    	readFile();
    	return levelProgression[mode];
    }
    
    /**
     * Get the student's score of a specific mode.
     * 0 is addition, 1 is subtraction, 2 is multiplication, 3 is division
     * 
     * @param mode the mode to get the level progression from
     * @return the student's score on a mode
     * @throws IOException if the file doesn't exist
     * @see readFile
     */
    public int getLevelScore(int mode) throws IOException {
    	readFile();
    	return levelScore[mode];
    }
    
    /**
     * Retrieve the student's data from StudentInfo.csv file
     * The data are saved in levelScore in the {@link getLevelScore} method 
     * and levelProgression in the {@link getLevelPrgression} method.
     * 
     * @throws IOException if the file doesn't exist
     */
    private void readFile() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream)); // Buffered Reading object
		
		String line = in.readLine(); // Read line by line from the text file
		line = in.readLine(); // Skip the first line
		
		while (line != null) {
			// Check for the correct student username
			String username = line.substring(0, line.indexOf(","));
			if (username.equals(super.getUsername())) {
				String[] res = line.split(",", 0); // Split the line into an array of String
				for (int i = 0; i < 4; i++) {
					levelProgression[i] = Integer.valueOf(res[i+2]); // Read the index 2-5 of res to levelProgression
					levelScore[i] = Integer.valueOf(res[i+6]); // Read the index 6-9 of res to levelScore
				}
			}
			line = in.readLine(); // Move to the next line
		}
		in.close();
    }
 
}
