import java.util.Scanner;

public class HangmanLab {
	static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String wordToGuess;
		StringBuilder wordShown = new StringBuilder();
		String hint;
		int wrongGuesses = 0;
		String currentGuess;
		String pastGuesses = "";
		
		System.out.print("Pick a word: ");
		wordToGuess = in.nextLine();
		
		for (int i = 0;i < wordToGuess.length();i++) {
			wordShown.append('_');
		}
		
		System.out.print("What is the hint for "+ wordToGuess + ": ");
		hint = in.nextLine();
		
		while(wrongGuesses <= 6) {
			wipeScreen();
			displayHangman(wrongGuesses, hint, wordShown, pastGuesses);
			currentGuess = getGuess();
			pastGuesses += currentGuess;
			
			boolean isCorrectGuess = false;
			for (int i = 0; i < wordToGuess.length();i++) {
				if (wordToGuess.substring(i,i+1).equals(currentGuess)) {
					isCorrectGuess = true;
					wordShown.setCharAt(i,currentGuess.charAt(0));
				}
			}
			if (!isCorrectGuess)
				wrongGuesses++;
			
			if (!wordShown.toString().contains("_")) {
				wipeScreen();
				System.out.println("You win!");
				System.out.println("The word was " + wordToGuess);
				break;
			}
		}
		if (wrongGuesses > 6) {
			wipeScreen();
			System.out.println("Sorry! you lost :(");
			System.out.println("The word was: " + wordToGuess);	
		}

		
		
	}
	
	static void wipeScreen() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n");
	}
	static void displayHangman(int wrongGuesses, String hint, StringBuilder wordShown, String pastGuesses) {
		System.out.println("The hint is: " + hint);
		System.out.print("Current word shown: ");
		for (int i = 0;i < wordShown.length();i++) {
			System.out.print(wordShown.charAt(i) + " ");
		}
		System.out.println();
		
		System.out.println("  ______");
		System.out.print("  |     ");
		if (wrongGuesses > 0)
			System.out.println("o");
		else System.out.println();
		System.out.print("  |    ");     //   /|\\
		if (wrongGuesses > 3)
			System.out.println("/|\\");
		else if (wrongGuesses > 2)
			System.out.println("/|");
		else if (wrongGuesses > 1)
			System.out.println("/");
		else System.out.println();
		System.out.print("  |     "); //     /\\
		if (wrongGuesses > 5)
			System.out.println("/\\");
		else if (wrongGuesses > 4)
			System.out.println("/");
		else System.out.println();
		System.out.println("-----   ");
		
		System.out.println("You have " + wrongGuesses + " wrong guesses.");
		System.out.print("Your current guesses were: ");
		for (int i = 0;i < pastGuesses.length();i++) {
			System.out.print(pastGuesses.substring(i,i+1) + ", ");
		}
		System.out.println();
	}
	
	static String getGuess() {
		System.out.print("Enter your guess: ");
		return in.nextLine();
	}

}
