package wordle;

import java.util.Scanner;
import java.util.Random;


public class WordleGame {
	private static String[] words = {"apple", "bunny", "cheer", "dunks", "frame"};
	
	/**
	 * Lowercase = in word, but not in right place
	 * Uppercase = in word, in right place
	 * @param actualWord the actual word
	 * @param guess the user guess
	 * @return the display string
	 */
	public static String display(String actualWord, String guess) {
		char[] actual = actualWord.toCharArray();
		char[] userGuess = guess.toCharArray();
		char[] display = new char[5];
		
		for (int i = 0; i < 5; i++) {
			if (actual[i] == userGuess[i]) {
				String temp = String.valueOf(actual[i]).toUpperCase();
				
				display[i] = temp.charAt(0);
				
				actual[i] = ' '; // set to blank since that letter was guessed
				userGuess[i] = ' '; // set to blank as well to avoid double counting later
			}
		}
		
		for (int i = 0; i < 5; i++) {
			if (actual[i] != ' ' && guess.contains(actualWord.substring(i, i + 1))) {
				int index = guess.indexOf(actualWord.substring(i, i + 1));
				
				String temp = String.valueOf(actual[i]).toLowerCase();
				display[index] = temp.charAt(0);
				
				actual[i] = ' '; // set to blank since that letter was dealt with
				userGuess[index] = ' '; // set to blank to avoid double counting
			}
		}
		
		String s = ""; 
		
		for (int i = 0; i < 5; i++) {
			if (display[i] != ' ') {
				s = s + display[i];
			}
			else {
				s = s + "_";
			}
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		Random rand = new Random();
		
		String randomWord = words[rand.nextInt(7)];
		
		Scanner s = new Scanner(System.in);
		String guess;
		int guesses = 0;
		
		System.out.print("Enter a guess (5-letter word)");
		guess = s.next();
		guesses++;
		
		while (guesses < 6) {
			if (guess.trim().length() != 5) {
				System.out.print("Invalid guess. Enter a 5-letter guess: ");
				guesses--;
				guess = s.next();
				continue;
			}
			
			if (guess.trim().equals(randomWord)) {
				System.out.println("Congrats! You guessed the word!");
			}
			
			System.out.print("Enter a guess (5-letter word)");
			guess = s.next();
			guesses++;
			
		}
		
	}

}
