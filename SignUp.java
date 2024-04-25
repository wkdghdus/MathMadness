import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The {@code SignUp} class is designed to handle the sign-up process for a new user,
 * including validation of user input, password confirmation, and username uniqueness checks.
 * It writes the new user's credentials to a CSV file upon successful account creation.
 * @author Atmiya Patel
 * @author Tony Li
 */
public class SignUp {

    /** instance variable for the new username */
    private String newUsername;
    /** instance variable for the new password */
    private String newPassword;
    /** instance variable for the password confirmation */
    private String confirmPassword;
    /** instance variable for the confirmation message */
    private String confirmationMessage;

    /**
     * Constructs a new {@code SignUp} instance and initiates the sign-up process with the provided credentials.
     * Validates the username and passwords, checks for username uniqueness, and writes to a CSV file upon successful sign-up.
     *
     * @param newUser      the username provided by the user.
     * @param newPass      the password provided by the user.
     * @param confirmPass  the password confirmation provided by the user.
     * @throws IOException if an I/O error occurs during file operations.
     */
    public SignUp(String newUser, String newPass, String confirmPass) throws IOException {
        if (newUser.length() >= 1) {
            if (newPass.length() >= 8) {
                if (usernameValidation(newUser)) {
                    if (checkIfBothPasswordsMatch(newPass, confirmPass)) {
                        setUsername(newUser);
                        setPassword(newPass);
                        writeToCSV(newUsername, newPassword);
                        confirmationMessage = signUpLabel(3); // Account successfully created
                    } else {
                        confirmationMessage = signUpLabel(1); // Passwords do not match
                    }
                } else {
                    confirmationMessage = signUpLabel(2); // Username exists
                }
            } else {
                confirmationMessage = signUpLabel(4); // Password is less than 8 characters
            }
        } else {
            confirmationMessage = signUpLabel(5); // Username is less than 1 character
        }
    }

    /**
     * Writes the new user's username and password to a CSV file, along with default values for other fields.
     *
     * @param newUser the new username to be written to the file.
     * @param newPass the new password to be written to the file.
     * @throws IOException if an I/O error occurs during writing to the file.
     */
    public void writeToCSV(String newUser, String newPass) throws IOException {
        String csvFile = "files/StudentInfo.csv";
        try (FileWriter fileWriter = new FileWriter(csvFile, true)) {
            fileWriter.append("\n");
            String[] user = {newUser, newPass, "1", "1", "1", "1", "0", "0", "0", "0"};
            fileWriter.append(String.join(",", user));
        } catch (IOException ioException) {
            System.out.println("Error writing to file: " + ioException.getMessage());
        }
    }

    /**
     * Validates the uniqueness of the username by checking against existing usernames in a CSV file.
     *
     * @param newUser the username to validate for uniqueness.
     * @return {@code true} if the username is unique, {@code false} otherwise.
     * @throws IOException if an I/O error occurs during reading from the file.
     */
    public boolean usernameValidation(String newUser) throws IOException {
        boolean validUser = true;
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
        String line;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream))) {
            while ((line = bf.readLine()) != null) {
                String[] username = line.split(",");

                if (username.length > 0 && username[0].equals(newUser)) {
                    validUser = false;
                    break;
                }
            }
        } catch (IOException ioException) {
            System.out.println("Error reading the file");
        }
        return validUser;
    }

    /**
     * Sets the {@code newUsername} field to the provided username.
     *
     * @param newUser the username to be set.
     */
    public void setUsername(String newUser) {
        newUsername = newUser;
    }

    /**
     * Sets the {@code newPassword} field to the provided password.
     *
     * @param newPass the password to be set.
     */
    public void setPassword(String newPass) {
        newPassword = newPass;
    }

    /**
     * Checks if the provided password and password confirmation match.
     *
     * @param pass        the password provided by the user.
     * @param confirmPass the password confirmation provided by the user.
     * @return {@code true} if the passwords match, {@code false} otherwise.
     */
    public boolean checkIfBothPasswordsMatch(String pass, String confirmPass) {
        return pass.equals(confirmPass);
    }

    /**
     * Returns a message based on the provided label integer, which represents different sign-up statuses.
     *
     * @param labelInt an integer representing the specific sign-up status message to return.
     * @return a {@code String} message corresponding to the sign-up status.
     */
    public String signUpLabel(int labelInt) {
        switch (labelInt) {
            case 1:
                return "Passwords do not match. Try again.";
            case 2:
                return "Username already exists, re-enter a new one.";
            case 3:
                return "Account successfully created. Click back to login.";
            case 4:
                return "Password is less than 8 characters. Try again.";
            default:
                return "Username must have at least 1 character.";
        }
    }

    /**
     * Gets the confirmation message indicating the result of the sign-up attempt.
     *
     * @return the confirmation message as a {@code String}.
     */
    public String getConfirmationMessage() {
        return confirmationMessage;
    }
}
