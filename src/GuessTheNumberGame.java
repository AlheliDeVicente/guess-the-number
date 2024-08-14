import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
  private Random random = new Random();
  private int targetNumber = random.nextInt(100);  // Genera un número entre 1 y 100

  public static void main(String[] args) {
    GuessTheNumberGame game = new GuessTheNumberGame();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escribe tu nombre");
    String userName = scanner.nextLine();
    Player human = new HumanPlayer(userName, scanner);
    Player computer = new ComputerPlayer();


    boolean isGuessed = false;
    while (!isGuessed) {
      isGuessed = game.checkGuess(human);
      if (!isGuessed) {
        isGuessed = game.checkGuess(computer);
      }
    }
  }

  public boolean checkGuess(Player player) {
    int guess = player.makeGuess();
    System.out.println(player.getName() + " Adivinó: " + guess);

    if (guess == targetNumber) {
      System.out.println(player.getName() + "Gana. El Número es: " + targetNumber);
        System.out.println("Historial de adivinanzas: " + player.getGuesses());
        return true;
        } else if(guess<targetNumber){
        System.out.println("El número es muy pequeño! Intenta otra vez");
      return false;
              } else {
              System.out.println("El número es muy grande!");
      return false;
              }
              }
              }




