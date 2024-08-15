import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
  private Random random = new Random(); // nuevo objeto de random//
  int targetNumber = random.nextInt(100);

  public static void main(String[] args) {
    GuessTheNumberGame game = new GuessTheNumberGame(); //nuevo objeto de la clase//
    Scanner scanner = new Scanner(System.in); //nuevo objeto de scanner//
    System.out.println("Enter UserName: "); //pedir dato a usuario//
    String userName = scanner.nextLine(); //leer dato usuario//
    Player human = new HumanPlayer(userName, scanner); //nuevo objeto clase player//
    Player computer = new ComputerPlayer(); //nuevo objeto clase player//
    boolean isGuessed = true;
    while (!isGuessed) {
      isGuessed = game.checkGuess(human);
      if (!isGuessed){
        game.checkGuess(computer);
      }
    }
  }
  boolean checkGuess (Player player) {
    int guess = player.makeGuess();
    System.out.println(STR."\{player.getName()} adivinó: \{guess}");
    if (guess == targetNumber) {
      Player human;
      System.out.println(STR."\{player.getName()} Ha ganadó. Los historiales de adivinanza son: \{player.getGuesses()}");
      return true;
    } else if (guess < targetNumber) {
      System.out.println("Número muy pequeño. Intenta otra vez");
      return false;
    } else {
      System.out.println("El número es muy grande. Intenta otra vez");
      return false;
    }
  }
}



