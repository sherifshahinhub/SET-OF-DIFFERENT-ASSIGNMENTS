package hungman;
import java.util.Scanner;
public class Main {
  static String[] directionary = new String[] {"GUESS1","GUESS2","GUESS3"}; // this should be read from file, instead of having them hard-coded
	
	public static void main(String[] args) {
		H_Class hangman = new H_Class();   // Here you will create an object of your class
		hangman.setDictionary(directionary);
		hangman.setMaxWrongGuesses(1);
		String secret = hangman.selectRandomSecretWord();
		Scanner input = new Scanner(System.in);  // Get user input
		Character guess = '0' ;
		System.out.println("GUESS the word!");
		do{
			String result = hangman.guess(guess);
			if(result == null){
				System.out.println("Fail! correct answer = '" + secret + "'"); // fail
				return;
			}
			System.out.println(result);
			if(!result.contains("-")){
				System.out.println("Well Done!");  // win
				return;
			}
			guess = input.next().charAt(0);
		} while(true);
	}
}