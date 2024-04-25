import java.io.*;

/**
 * This class is used to support the levels of the game. It will be used to keep track of the levels unlocked and the scores of the user.
 * 
 * <p>
 * This class will furthermore be used to update the studentInfo.csv file with the new information. 
 * Every time a user completes a level, the levelsUnlocked and levelScores will be updated and the file will be updated.
 * </p>
 * 
 * @version 1.0
 * @auther Hoyeon Luke Jang
 * @auther Atmiya Patel
 * @auther Ben Santhosh
 */
public class Levels {
    
    /** instance variable for the username */
    private String user;
    /** instance variable for the number of levels unlocked per mode, (index 0 = add, index 1 = sub, index 2 = mult, index 3 = div)*/
    private int[] levelsUnlocked = new int[4];
    /** instance variable for score per mode, (index 0 = add, index 1 = sub, index 2 = mult, index 3 = div) */
    private int[] levelScores = new int[4];

    /**
     * Constructor for the Levels class.
     * Initializes the levelsUnlocked and levelScores arrays based on the user's information in the studentInfo.csv file.
     * Points are calculated based on how many levels are unlocked, with each level worth 100 points.
     * 
     * @param gameMode The game mode the user is playing (0 = add, 1 = sub, 2 = mult, 3 = div).
     * @param newUser The username of the user.
     */
    public Levels(int gameMode, String newUser) {
        try {
            InputStream inputStream = Levels.class.getClassLoader().getResourceAsStream("files/StudentInfo.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            
            this.user = newUser;

            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] studentInfo = line.split(",");

                if (studentInfo.length > 0 && studentInfo[0].equals(this.user)) {
                    levelsUnlocked[0] = Integer.parseInt(studentInfo[2]);
                    levelsUnlocked[1] = Integer.parseInt(studentInfo[3]);
                    levelsUnlocked[2] = Integer.parseInt(studentInfo[4]);
                    levelsUnlocked[3] = Integer.parseInt(studentInfo[5]);

                    levelScores[0] = (levelsUnlocked[0] - 1) * 100;
                    levelScores[1] = (levelsUnlocked[1] - 1) * 100;
                    levelScores[2] = (levelsUnlocked[2] - 1) * 100;
                    levelScores[3] = (levelsUnlocked[3] - 1) * 100;
                    break; 
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading studentInfo.csv file.");
            e.printStackTrace();
        }
    }


    // Getters and Setters

    /**
     * Getter for the levelsUnlocked array.
     * Each index of the array corresponds to a game mode (0 = add, 1 = sub, 2 = mult, 3 = div).
     * 
     * @return The levelsUnlocked array.
     */
    public int[] getLevelsUnlocked(){
        return this.levelsUnlocked;
    }

    /**
     * Setter for the levelsUnlocked.
     * Each index of the array corresponds to a game mode (0 = add, 1 = sub, 2 = mult, 3 = div).
     * setLevelsUnlocked will update the score of each level using {@link #setScore(int, int)}.
     * StudentInfo.csv file will be updated with the new levels unlocked and scores using {@link #updateFile()} in {@link #setScore(int, int)} method.
     * 
     * @param mode The game mode the user is playing (0 = add, 1 = sub, 2 = mult, 3 = div).
     * @param newLevelsUnlocked The new levels unlocked for the user.
     */
    public void setLevelsUnlocked(int mode, int newLevelsUnlocked){
        this.levelsUnlocked[mode] = newLevelsUnlocked + 1;
        this.setScore((newLevelsUnlocked) * 100, mode);
    }

    /**
     * Getter for the levelScores.
     * Each index of the array corresponds to a game mode (0 = add, 1 = sub, 2 = mult, 3 = div).
     * 
     * @param mode The game mode the user is playing (0 = add, 1 = sub, 2 = mult, 3 = div).
     * @return The score of the user in the specified game mode.
     */
    public int getScore(int mode){
        return this.levelScores[mode];
    }

    /**
     * Setter for the levelScores, ran automatically when setLevelsUnlocked is called.
     * Each index of the array corresponds to a game mode (0 = add, 1 = sub, 2 = mult, 3 = div).
     * setScore will update the StudentInfo.csv file with the new score using {@link #updateFile()}.
     * 
     * @param newScore The new score of the user in the specified game mode.
     * @param mode The game mode the user is playing (0 = add, 1 = sub, 2 = mult, 3 = div).
     */
    public void setScore(int newScore, int mode){
        this.levelScores[mode] = newScore;
        updateFile();
    }

    /**
     * Method to update the studentInfo.csv file with the new information.
     * Ran automatically with setScore and Update file.
     */
    private void updateFile(){

        try{
            InputStream inputStream = Levels.class.getClassLoader().getResourceAsStream("files/StudentInfo.csv");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            String[] studentInfo = line.split(",");
            StringBuilder newFile = new StringBuilder();

            // Find the user in the studentInfo.csv, update the information, and write to a new file
            while(!studentInfo[0].equals(this.user)){
                newFile.append(line).append("\n");
                line = reader.readLine();
                studentInfo = line.split(",");
            }

            newFile.append(studentInfo[0]).append(",").append(studentInfo[1]).append(",").append(this.levelsUnlocked[0]).append(",").append(this.levelsUnlocked[1]).append(",").append(this.levelsUnlocked[2]).append(",").append(this.levelsUnlocked[3]).append(",").append(this.levelScores[0]).append(",").append(this.levelScores[1]).append(",").append(this.levelScores[2]).append(",").append(this.levelScores[3]).append("\n");

            while((line = reader.readLine()) != null){
                newFile.append(line).append("\n");
            }

            reader.close();

            // Write to file
            try(FileWriter writer = new FileWriter("files/StudentInfo.csv")) {
                writer.write(newFile.toString());
            } catch (Exception e) {
                e.printStackTrace();
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

}
