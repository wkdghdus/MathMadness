import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

/**
 * The {@code Leaderboard} class is designed to parse a CSV file containing user scores and
 * produce a leaderboard. The CSV file is expected to have multiple columns, with at least one column
 * containing integer scores. The class allows for the retrieval of the top 5 high scores from a specified column.
 * @author Ben Santhosh
 * @author Tony Li
 */
public class Leaderboard {
	private int counter = 0;
    private String csvFilePath;

    /**
     * Constructs a new {@code Leaderboard} instance with the specified CSV file path.
     *
     * @param csvFilePath the path to the CSV file containing user scores.
     */
    public Leaderboard(String csvFilePath) {
        this.csvFilePath = csvFilePath;
    }

    /**
     * A helper class to represent a pair of username and score.
     */
    private static class UserScore {
        String username;
        int score;

        /**
         * Constructs a {@code UserScore} instance with the specified username and score.
         *
         * @param username the username of the user.
         * @param score    the score of the user.
         */
        public UserScore(String username, int score) {
            this.username = username;
            this.score = score;
        }
    }

    /**
     * Retrieves the top 5 high scores from the specified column in the CSV file.
     * The method returns a 2D String array containing the usernames and their corresponding scores.
     * The first row of the array contains the usernames, and the second row contains the scores.
     *
     * @param column the index of the column in the CSV file from which to extract the scores.
     *               The first column has an index of 0.
     * @return a 2D String array where the first row contains usernames and the second row contains their scores.
     * @throws IOException if an I/O error occurs reading from the file.
     */
    public String[][] highScores(int column) throws IOException {
        List<UserScore> scoresList = new ArrayList<>();
        counter = 0;
        
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("files/StudentInfo.csv");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            br.readLine(); // Skip the header line
            br.readLine(); // Skip the Instructor line
            br.readLine(); // Skip the Debugger line
            while ((line = br.readLine()) != null) {
            	counter++;
                String[] values = line.split(",");
                if (column >= 0 && column < values.length) {
                    try {
                        int score = Integer.parseInt(values[column]);
                        scoresList.add(new UserScore(values[0], score)); // Store username and score
                    } catch (Exception e) {
                        // Ignoring parse errors and moving to the next line
                    }
                }
            }
        }

        // Sort scoresList based on scores in descending order
        scoresList.sort(Comparator.comparingInt((UserScore user) -> user.score).reversed());

        // Get top 5 scores and usernames
        int size = Math.min(scoresList.size(), counter); 
        String[] usernames = new String[size];
        int[] scores = new int[size];
        for (int i = 0; i < size; i++) {
            usernames[i] = scoresList.get(i).username;
            scores[i] = scoresList.get(i).score;
        }

        return new String[][] { usernames, Arrays.stream(scores).mapToObj(String::valueOf).toArray(String[]::new) };
    }
    public int getCSVLength() {
    	return counter;
    }
}
