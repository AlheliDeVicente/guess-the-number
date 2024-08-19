import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
  private Random random = new Random(); // nuevo objeto de random//
  int targetNumber = random.nextInt(100);
  static Scanner scanner;

  public static void main(String[] args) {
    GuessTheNumberGame game = new GuessTheNumberGame(); //nuevo objeto de la clase//
    scanner = new Scanner(System.in); //nuevo objeto de scanner//
    System.out.println("Ingresa tu nombre de usuario: "); //pedir dato a usuario//
    String userName = scanner.nextLine(); //leer dato usuario//
    Player human = new HumanPlayer(userName, scanner); //nuevo objeto clase player, llama al constructor de HumanPlayer//
    Player computer = new ComputerPlayer(); //nuevo objeto clase player, llama al constructor de ComputerPlayer//
    boolean playTurn = true; //variable booleana que administra los turnos, incia en true para que se ejecute siempre un turno//
    while (playTurn) { //mientras se mantenga true se cumple el siguiente loop//
    //isGuessed falso para que el loop se cumpla muchas veces, el chiste es decirle que el número AUN NO se adivina//
    boolean isGuessed = false;
    //mientras isGuessed sea falso, turnos para que se chequen los numeros de los jugadores//
    while (!isGuessed) {
      isGuessed = game.checkGuess(human);
      if (!isGuessed){
        game.checkGuess(computer);
      }
    }
   playTurn = game.playAgain(human, computer); //cuando el juego se cumpla, llamar a este método//

    }
  }
  //checar las respuestas//
  boolean checkGuess (Player player) {
    int guess = player.makeGuess();
    int totalguesses = player.getGuesses().toArray().length;
    System.out.println("---" + player.getName() + "----" + "\n adivinó: " + guess);
    if (guess == targetNumber) {
      System.out.println(STR."\{player.getName()} Ha ganadó. Los historiales de adivinanza son: \{player.getGuesses()}");
      System.out.println("El total de intentos fue: " + totalguesses);
      return true;
    } else if (guess < targetNumber) {
      System.out.println("Número muy pequeño. Intenta otra vez");
      return false;
    } else {
      System.out.println("El número es muy grande. Intenta otra vez");
      return false;
    }
  }
  boolean playAgain (Player human, Player computer){
    System.out.println("¿Otra partida? (s/n)");
    String response = scanner.nextLine();
    if (response.equals("s")) {
      targetNumber = random.nextInt(100);
      human.reset();
      computer.reset();
      System.out.println("¡Nueva partida comenzada!");
      return true;
    } else{
      return false;
    }
    }
  }




