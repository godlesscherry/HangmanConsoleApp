import java.util.Random;
import java.util.Scanner;

public class HangmanConsoleGame {
    static String[] word_pool = {"create", "start", "guess", "word", "stop",
                                "destroy", "win", "lose", "hangman", "play",
                                "user", "system", "print", "random"};

    public static void main(String[] args) {
        start(word_pool);
    }

    public static void start(String[] word_pool) {
        // randomly pick a word.
        System.out.println("******** GAME START **********");
        Random random = new Random();
        int index = random.nextInt(word_pool.length);
        String word = word_pool[index];

        // display guesses left
        int chances = word.length();
        System.out.println("Guesses  left : " + chances);

        char[] chars = word.toCharArray();
        String revealed_word = "";
        System.out.println("????  Guess The Word   ???");

        // prepopulate vowels
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'a' || chars[i] == 'e' || chars[i] == 'i' || chars[i] == 'o' || chars[i] == 'u') {
                System.out.print(chars[i]);
                revealed_word = revealed_word + chars[i];
            } else {
                System.out.print("_");
                revealed_word = revealed_word + "_";
            }
        }
        System.out.println();
        processGuess(chances, chars, revealed_word);

    }

    //GUESS
    public static void processGuess(int chances, char[] charsInWord, String revealed_word) {
        // keep asking user to guess till there are chances
        String guess_history = "";
        boolean correctGuess = false;

        while (chances > 0) {
            boolean win = true;
            System.out.print("Enter Char: ");
            Scanner sc = new Scanner(System.in);
            String user_in = sc.nextLine().toLowerCase();
            char[] u = user_in.toCharArray();
            char user_input = u[0];

            guess_history = guess_history + user_in + " ";
            System.out.println("YOUR GUESS HISTORY: " + guess_history);
            chances--;
            System.out.println("chances left: " + chances);

            char[] revealedCharsInWord = revealed_word.toCharArray();

            //check if user_input is present in the word
            for (int i = 0; i < charsInWord.length; i++) {
                if (charsInWord[i] == user_input) {
                    correctGuess = true;
                    System.out.println("WOW! you guessed right");
                    revealedCharsInWord[i] = user_input;
                }
            }
            if(correctGuess = false){
                System.out.println("Incorrect guess! Try again..");
            }
            // refresh the revealed word
            System.out.println("####### Refreshing your word! #########");
            System.out.println();
            revealed_word = "";
            for (char c : revealedCharsInWord) {
                if (c == '_') {
                    win = false;
                }
                revealed_word += c;
                System.out.print(c);
            }
            System.out.println();
            //check for a win
            if (win) {
                System.out.println("CONGRATS! YOU WIN");
                return;
            }
            // check for game over
            if (chances < 1) {
                System.out.println("GAME OVER: You ran out of chances!");
                return;
            }
            System.out.println();
            System.out.println("*********** KEEP PLAYING *********");

        }

    }
}


