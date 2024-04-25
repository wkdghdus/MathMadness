/**
 * This class is used to create a question object that will be used in the game
 * 
 * <p>
 * this class contains the answer and the String of the question of each questions.
 * The question is created based on the game mode and the subLevel of the game.
 * Game mode will determine the type of question with 0 being addition, 1 is subtraction, 2 is multiplication, and 3 is division.
 * The subLevel will determine the difficulty of the question with broader and higher range of the numbers as subLevel progresses. 
 * </p>
 * 
 * @version 1.0
 * @author Hoyeon Luke Jang
 * @author Atmiya Patel
 * @author Ben Santhosh
 */

import java.util.*;

public class Question {
    
    /** instance variable for sub level of the game, this will differ the difficulty of the question*/
    private int subLevel;
    /** instance variable for the question */
    private String question;
    /** instance variable for the answer */
    private int answer;
    /** 
     * instance variable for the question's range of number, the number will be adjusted using this array based on the subLevel
    */
    private int[] questionRange = {5, 10, 50, 100};
    /**
     * instance variable for the question's range of number, but for the multiplication question
     */
    private int[] multiplicationRange = {3, 6, 8, 12};
    /**
     * instance variables for the question's range of number, but for the division question
     */
    private int[] divisionRange = {1, 4, 7, 9};
    private int[] divisionRange1 = {5, 5, 10, 12};
    private int[] divisionRange2 = {1, 2, 5, 5};

    /**
     * instance variable for the options array, this will be used to store the options for the multiple choice question
     */
    private int[] optionsArray;


    /**
     * Constructor for the Question class
     * <p>
     * Creates question using the helper methods based on the game mode and subLevel
     * </p>
     * 
     * @param gameMode The game mode of the question (0 = add, 1 = sub, 2 = mult, 3 = div)
     * @param subLevel The subLevel of the question where 1 being the lowest and 5 being the highest
     */
    public Question(int gameMode, int subLevel) {

        this.subLevel = subLevel;

        //create a question and answer based on the game mode
        switch(gameMode){

            //game mode 0 is addition
            case 0:
                createAdditionQuestion();
                break;
            //game mode 1 is subtraction
            case 1:
                createSubtractionQuestion();
                break;
            //game mode 2 is multiplication
            case 2:
                createMultiplicationQuestion();
                break;
            //game mode 3 is division
            case 3:
                createDivisionQuestion();
                break;
            //default case --> invalid game mode
            default:
                System.out.println("Invalid game mode");
                break;

        }
        
    }

    //getters and setters

    /**
     * getter for the question
     * 
     * @return String value of the question
     */
    public String getQuestion() {
        return this.question;
    }

    /**
     * Setter for the question
     * 
     * @param newQuestion the new question to be set
     */
    public void setQuestion(String newQuestion) {
        this.question = newQuestion;
    }


    /**
     * Getter for the answer
     * 
     * @return double value of the answer
     */
    public int getAnswer() {
        return this.answer;
    }

    /**
     * Setter for the answer
     * 
     * @param newAnswer the new answer to be set
     */
    public void setAnswer(int newAnswer) {
        this.answer = newAnswer;
    }

    //helper methods to create questions
    /**
     * Helper method to create an addition question
     */
    private void createAdditionQuestion() {
        
        //create an addition question
        Random rand = new Random();
        //generate two random numbers between 0 and the question range
        int num1 = rand.nextInt(questionRange[this.subLevel] /* +1 */);
        int num2 = rand.nextInt(questionRange[this.subLevel] /* +1 */);

        //create the question and answer
        this.question = num1 + " + " + num2;
        this.answer = num1 + num2;

    }

    /**
     * Helper method to create a subtraction question
     */
    private void createSubtractionQuestion() {
        
        //create an addition question
        Random rand = new Random();
        //generate two random numbers between 0 and the question range
        int num1 = rand.nextInt(questionRange[this.subLevel] /* +1 */);
        int num2 = rand.nextInt(questionRange[this.subLevel] /* +1 */);

        //make sure the result is always positive by having num1 as a larger number
        if (num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }

        //create the question and answer
        this.question = num1 + " - " + num2;
        this.answer = num1 - num2;

    }

    /**
     * Helper method to create a multiplication question
     * 
     */
    private void createMultiplicationQuestion() {

        //create a multiplication question
        Random rand = new Random();
        //generate two random numbers between 0 and the question range
        int num1 = rand.nextInt(10-5/* +1 */) + 5;
        int num2 = 0;
        
        if(this.subLevel > 0) {
        	num2 = rand.nextInt(multiplicationRange[this.subLevel] - multiplicationRange[this.subLevel-1] /* +1 */) + multiplicationRange[this.subLevel-1] ;
        }
        else {
        	num2 = rand.nextInt(multiplicationRange[this.subLevel]) ;
        }

        //create the question and answer
        this.question = num1 + " X " + num2;
        this.answer = num1 * num2;

    }

    /**
     * Helper method to create a division question
     * 
     * <p>
     * the numbers are generated through multiplication so that the answer is always an integer
     * </p>
     */
    private void createDivisionQuestion() {
        
        // Create a division question
        Random rand = new Random();
        
        // Generate two random numbers for the division
        // Ensure that the second number is not 0 to avoid division by zero
        int num2 = rand.nextInt(divisionRange2[subLevel],divisionRange1[subLevel]); // Ensure num2 is not 0
        int num1 = rand.nextInt(divisionRange[subLevel], multiplicationRange[subLevel]);
        

        // Create the question and answer
        this.question = num1 * num2 + " / " + num2;
        this.answer = num1; 
    }

    
    /**
     * A method that creates a meaningful multiple choice options for the question
     * 
     * @return array of the options, with the correct answer being in the first index
     */
    public int[] generateOptions() {
        boolean flag = false;
        int answer = this.answer;
        int ans1 = 0;
        int ans2 = 0;

        Random rand = new Random();
        while (!flag) {
            ans1 = rand.nextInt((answer + 10) - (answer-10)) + (answer-10); // Corrected bounds to include 0 to answer+25
            ans2 = rand.nextInt(answer + 10 - (answer-10)) + (answer-10);
            if (ans1 != ans2 && ans1 != answer && ans2 != answer && ans1 >= 0 && ans2 >= 0) { // Changed || to &&
                flag = true;
            }
        }

        int[] optionsArray = {answer, ans1, ans2};
        

        for (int i = 0; i < optionsArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(optionsArray.length);
            int temp = optionsArray[randomIndexToSwap];
            optionsArray[randomIndexToSwap] = optionsArray[i];
            optionsArray[i] = temp;
        }

        this.optionsArray = optionsArray;
        return optionsArray;
    }

}
