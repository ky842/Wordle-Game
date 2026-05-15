package wordle;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;


public class WordleGame {
	private static String[] words = {"apple", "bunny", "cheer", "dunks", "frame", "gains", "giant"};
	
	/**
	 * Lowercase = in word, but not in right place
	 * Uppercase = in word, in right place
	 * @param actualWord the actual word
	 * @param guess the user guess
	 * @return the display string
	 */
	public static String display(String actualWord, String guess) {
		actualWord = actualWord.toLowerCase();
		guess = guess.toLowerCase();
		
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
			if (actual[i] != ' ' && contains(userGuess, Character.valueOf(actual[i]))) {
				int index = indexOf(userGuess, Character.valueOf(actual[i]));
				
				String temp = String.valueOf(actual[i]).toLowerCase();
				display[index] = temp.charAt(0);
				
				actual[i] = ' '; // set to blank since that letter was dealt with
				userGuess[index] = ' '; // set to blank to avoid double counting
			}
		}
		
		String s = ""; 
		
		for (int i = 0; i < 5; i++) {
			if (display[i] != '\u0000') {
				s = s + display[i];
			}
			else {
				s = s + "_";
			}
		}
		

		return s;
	}
	
	private static boolean contains(char[] arr, char c) {
		for (char ch : arr) {
			if (ch == c) {
				return true;
			}
		}
		
		return false;
	}
	
	private static int indexOf(char[] arr, char c) {
		int idx = 0;
		
		for (char ch : arr) {
			if (ch == c) {
				return idx;
			}
			
			idx++;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Instructions: 6 tries to guess a 5-letter word.\n");
		System.out.println("An uppercase letter indicates a letter is present in the word and in the right spot.");
		System.out.println("A lowercase letter indicates a letter is present in the word, but in the wrong spot.");
		System.out.println("An underscore indicates that a particular letter is either not in the word or is an extra, unnecessary letter.");
		
		
		System.out.print("\nEnter 'y' to play. Enter anything else to quit: ");
		
		String response = s.next();
		
		while ("y".equals(response.trim())) {
			boolean win = false;
			
			Random rand = new Random();
			
			String randomWord = words[rand.nextInt(7)];
			
			String guess;
			int guesses = 0;
			
			System.out.print("Enter a guess (5-letter word): ");
			guess = s.next().toLowerCase();
			guesses++;
			
			while (guesses < 6) {
				if (guess.trim().length() != 5) {
					System.out.print("\nInvalid guess. Enter a 5-letter guess: ");
					guesses--;
					guess = s.next().toLowerCase();
					continue;
				}
				
				System.out.println("Result: " + display(randomWord, guess) + "\n");
				
				if (guess.trim().equals(randomWord)) {
					System.out.println("Congrats! You guessed the word!\n");
					win = true;
					break;
				}
				
				System.out.print("Enter a guess (5-letter word): ");
				guess = s.next().toLowerCase();
				guesses++;
				
			}
			
			if (!win) {
				System.out.println("Result: " + display(randomWord, guess)  + "\n");
				if (guess.trim().equals(randomWord)) {
					System.out.println("Congrats! You guessed the word!\n");
				}
			}
			
			System.out.print("Enter 'y' to play again. Enter anything else to quit: ");
			response = s.next();
		}
	}

}
