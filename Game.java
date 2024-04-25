/**
 * A game class that contains the game logic and the question bank.
 * <p>
 * This class supports the actual gameplay aspect of the program. 
 * This class will be used when the user selects a level and enters the game to clear the stage.
 * </p>
 * 
 * @version 1.0
 * @author Atmiya Patel
 * @author Ben Santhosh
 * @author Tony Baocheng Li
 * @author Hoyeon Luke Jang
 */

 public class Game {
    private int subLevel;

    /**
     * The number of lives the player has remaining.
     */
    private int lives;

    /**
     * An array storing the bank of questions for the current level.
     */
    private Question[] questionBank;

    /**
     * The count of correctly answered questions in the current level.
     */
    private int correctAnswer;

    /**
     * The current game mode, which may affect the type of questions generated.
     */
    private int gameMode;

	/**
	 * Constructor for the Game class
	 * 
	 * <p>
	 * initializes the lives to 3, the question bank to an array of 5 questions, and the correct answer to 0.
	 * To generate the question bank, the constructor will call the {@link createQuestionBank} method. 
	 * Then it will check for duplicated questions in the question bank using
	 * </p>
	 */
    public Game(int level, int gameMode) {
        this.lives = 3;
        this.questionBank = new Question[5];    
        this.correctAnswer = 0;
		this.subLevel = level;
		this.gameMode = gameMode;
		createQuestionBank();
		checkDuplicatedQuestions();
    }

    /**
     * Sets up the game for play at the specified level.
     * Initializes the question bank for the level and checks for any duplicate questions.
     *
     * @param level The level at which the game is to be played.
     */
    public void gamePlay(int level) {
        this.subLevel = level;
        this.correctAnswer = 0;
        createQuestionBank();
        checkDuplicatedQuestions(); 
    }

    /**
     * Checks if the player has passed the current level by answering enough questions correctly
     * and having at least one life remaining.
     *
     * @return true if the player has passed the level, false otherwise.
     */
    public boolean passedLevel() {
        return this.correctAnswer >= 5 && this.lives > 0;
    }

    /**
     * Increments the count of correctly answered questions.
     */
    public void incrementCorrectAnswers() {
        this.correctAnswer++;
    }

    /**
     * Sets the current sub-level of the game.
     *
     * @param subLevel The sub-level to set.
     */
    public void setSubLevel(int subLevel) {
        this.subLevel = subLevel;
    }

    /**
     * Retrieves the current sub-level of the game.
     *
     * @return The current sub-level.
     */
    public int getSubLevel() {
        return this.subLevel;
    }

    /**
     * Retrieves the number of remaining lives for the player.
     *
     * @return The number of remaining lives.
     */
    public int getRemainingLives() {
        return this.lives;  
    }

    /**
     * Deducts a life from the player's remaining lives, if any are left.
     */
    public void deductRemainingLives() {
        if (lives > 0) lives--;
    }

    /**
     * Creates a set of unique questions for the current level and stores them in the question bank.
     */
    private void createQuestionBank() {
        for (int i = 0; i < questionBank.length; i++) {
            this.questionBank[i] = new Question(gameMode, subLevel);
        }
    }

    /**
     * Checks the question bank for duplicated questions and replaces any found with unique ones.
     */
    private void checkDuplicatedQuestions() {
        for (int i = 0; i < questionBank.length; i++) {
            for (int j = i + 1; j < questionBank.length; j++) {
                if (questionBank[i].getQuestion().equals(questionBank[j].getQuestion())) {
                    boolean isUnique;
                    Question newQuestion;
                    
                    do {
                        isUnique = true;
                        newQuestion = new Question(gameMode, subLevel);

                        for (int k = 0; k < questionBank.length; k++) {
                            if (k != j && newQuestion.getQuestion().equals(questionBank[k].getQuestion())) {
                                isUnique = false;
                                break;
                            }
                        }
                    } while (!isUnique);

                    questionBank[j] = newQuestion;
                }
            }
        }
    }
    
    /**
     * getter for the question bank
     * 
     * @return the question bank array
     */
    public Question[] getQuestionBank() {
   	    return questionBank;
    }
    
}
 



