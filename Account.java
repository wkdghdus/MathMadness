import java.io.*;

	/**
	 * The Account class that is used to create an Student, Instructor, or Debugger account object.
	 * <br><br>
	 * The input username and password are put through the {@link validateCredentials} method through the database
	 * to check if the account is valid
	 * 
	 * @author Ben Santhosh
	 * @author Atmiya Patel
	 *
	 */

public class Account {
    /** The account's username. */
    private String username;
    /** The account's password. */
    private String password;
    /** The log in confirmation message for account*/
    private String confirmationMessage;
    /**	The log in status of the account */
    private boolean successfulLogin;
    
	/** 
     * Account constructor. Create a new Account object.
     * 
     * @param user the account's username
	 * @param pass the account's password
     * @throws IOException if file doesn't exist
     * @see validateCredentials
     */
    public Account (String user, String pass) throws IOException{
    	validateCredentials(user, pass);
    }
    
	/**
     * Get the account's username.
     * 
     * @return the account's username
     */
    public String getUsername() {
    	return this.username;
    }
    
	/**
     * Get the account's password
     * 
     * @return the account's password
     */
    public String getPassword() {
    	return this.password;
    }
    
	/**
     * Check if the account is valid or not by checking the account's username and password exists in
     * the database. 
     * 
     * @param user the account's username
     * @param pass the account's password
     * @throws IOException if the file doesn't exist
     * @see logInLabel
	 * @see getConfirmationMessage
	 * @see getSuccessfulLogin
     */
    public void validateCredentials(String user, String pass) throws IOException {
        successfulLogin = false;
        
        boolean validLogin = false;
        boolean validUsername = false;
        
        String line;

        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
            BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream));
            
            while ((line = bf.readLine()) != null) {
                String[] userName = line.split(",");

                if(userName[0].equals(user)) {
                    validUsername = true;
                    if(userName[1].equals(pass)) {
                        validLogin = true;
                        confirmationMessage = logInLabel(1);
                        successfulLogin = true;
                        this.username = user;
                        this.password = pass;
                    }
                    else {
                        confirmationMessage = logInLabel(2);
                    }
                }
            }
            if (!validUsername) {
                confirmationMessage = logInLabel(3);
            }
            bf.close();
        }
        catch (IOException e){ 
            System.out.println("Error reading file");
        }
    }

    
	/**
     * Create a string that is corresponding to the account log-in status.
     * "Successfully logged in" if both the username and password are valid
     * "Incorrect password" if the password is invalid
     * "Username does not exist" if username isn't found in the database
     * 
     * @param confirm the log-in status 
     * @return
     */
    public String logInLabel(int confirm) {
    	if(confirm == 1) {
    		return "Successfully logged in.";
    	}
    	else if (confirm == 2){
    		return "Incorrect password.";
    	}
    	else {
    		return "Username does not exist."; 
    	}
    }
    
	/**
     * Get the confirmation message on the account validation process
     * 
     * @return the confirmation message
     */
    public String getConfirmationMessage() {
    	return confirmationMessage;
    }
    
	/**
     * Get the login status of the account
     * 
     * @return the login status
     */
    public boolean getSuccessfulLogin() {
    	return successfulLogin;
    }
    
}
