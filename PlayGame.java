import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.List;


/**
 * This is the main class that is run to play the game
 * 
 * @version 1.0
 * @author Atmiya Patel
 * @author Ben Santhosh
 */
public class PlayGame {
	
	/**Variable for the username (unique id)*/
	static String userName;
	
	public static void main(String [] args) {
		
		String csvFilePath = "updated_StudentInfo.csv";
		
		LogInPage loginPage = new LogInPage();
        SignUpPage signUpPage = new SignUpPage();
		loginPage.setVisible(true); 
		userName = loginPage.userName;
		
	}
    
}