import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

	
/**
 * Instructor account that extends from the Account class for getting Student's information
 * <br><br>
 * Student's information is retrieved from StudentInfo.csv by the {@link getStudentMetrics} method
 * 
 * @author Atmiya Patel
 * @author Minh Pham
 */

public class Instructor extends Account{
    private String confirmationMessage;
		
	/**
	 * Instructor constructor. Create a new Instructor account object
	 * 
	 * @param password the account's password
	 * @throws IOException if the file doesn't exist
	 */
	 
	 
	public Instructor(String password) throws IOException {
		super("Instructor", password);
	}
	
	/**
	 * Retrieve the student's data from StudentInfo.csv file
	 * The data are used to keep track of the student's progression
	 * 
	 * @param studentUser a specific student's data to retrieve from the file
	 * @return the student's metric which includes their level progression and top scores, returns "No Student Found." if nothing found
	 * @throws IOException if the file doesn't exist
	 */
	public String[] getStudentMetrics(String studentUser) throws IOException {
		
		boolean validUsername = false;
		String line;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
		
		try {
			while ((line = bf.readLine()) != null) {
			    String[] userName = line.split(",");
	
			    if(userName[0].equals(studentUser)) {
			    	validUsername = true;
			    	return userName;
			    		
			    	}
			}
			if (validUsername == false) {
				confirmationMessage = logInLabel(3);
			}
			bf.close();
	    	}
		catch (IOException e){ 
			 System.out.println("Error reading file");
		}
		
		return null;
	}
	
	/**
	 * Check if the instructor's password is correct, i.e. the password is "IamAnInstructor"
	 * 
	 * @param iPass the instructor's password
	 * @return return true if pass, false otherwise
	 */
	public boolean checkIfInstructorPassCorrect(String iPass) {
		if(iPass.equals("IamAnInstructor")) {  // instructor password
			return true;
		}
		else {
			return false;
		}
	}
	
public static void main(String[] args) {
	try {
		Instructor inst = new Instructor("IAmAnInstructor");
		System.out.println(inst.getStudentMetrics("ben")[2]);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}