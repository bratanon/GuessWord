import java.util.Random;
import java.util.Scanner;

/**
 * Guess a scrambled word.
 * 
 * @author Emil
 *
 */
public class GuessWord {

  public static void main(String[] args) {
    
    String[] words = {
      "Anmälningar",
      "Åskväder",
      "Kruka",
      "Granne",
      "Spionbas"
    };
    
    Random rand = new Random();
    int r = rand.nextInt(5);
    
    //System.out.println(words[r].toLowerCase());
    
    // Create a new char array with the size of the random word.
    char[] chars = new char[words[r].length()]; 
    
    // Populate the char array.
    for (int i = 0; i < words[r].length(); i++) {
      chars[i] = words[r].toLowerCase().charAt(i);
    }
    
    for (int i=0; i < chars.length; i++) {
      int randomPosition = rand.nextInt(chars.length);
      char temp = chars[i];
      chars[i] = chars[randomPosition];
      chars[randomPosition] = temp;
    }
    
    // Save the scrambled word in a new string.
    String scrambledWord = new String(chars);
    
    Scanner userInput = new Scanner(System.in);
        
    System.out.println("Guess the word, you have three guesses.");
    
    for (int i = 0; i < 3; i++) {
      System.out.println("What is " + scrambledWord + "?");
      
      if (userInput.nextLine().toLowerCase().equals(words[r].toLowerCase())) {
        System.out.println("Congraz, you have found the word.");
        break;
      }
      else {
        System.out.println("Oops, that is not the correct word.");
      }
    }
    
    userInput.close();
    System.exit(0);
  }

}
