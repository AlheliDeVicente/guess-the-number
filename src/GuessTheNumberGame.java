import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
  private Random random; // nuevo objeto de random//
  int targetNumber;
  static Scanner scanner;

  public GuessTheNumberGame(){
    this.random = new Random();
    this.targetNumber = random.nextInt(3);
  }

  public static void setScanner(Scanner scanner) {
    GuessTheNumberGame.scanner = scanner;
  };

  public static void main(String[] args) {
    //nuevo objeto de la clase//
    GuessTheNumberGame game = new GuessTheNumberGame();
    //nuevo objeto de scanner//
    scanner = new Scanner(System.in);
    //pedir dato a usuario//
    System.out.println("Ingresa tu nombre de usuario: ");
    //leer dato usuario//
    String userName = scanner.nextLine();
    //nuevo objeto clase player, llama al constructor de HumanPlayer//
    Player human = new HumanPlayer(userName, scanner);
    //nuevo objeto clase player, llama al constructor de ComputerPlayer//
    Player computer = new ComputerPlayer();
    //variable booleana que administra los turnos, incia en true para que se ejecute siempre un turno//
    boolean playTurn = true;
    //mientras se mantenga true se cumple el siguiente loop//
     while (playTurn) {
    //isGuessed falso para que el loop se cumpla muchas veces, el chiste es decirle que el número AUN NO se adivina//
        boolean isGuessed = false;
        //mientras isGuessed sea falso, turnos para que se chequen los numeros de los jugadores//
          while (!isGuessed) {
            isGuessed = game.checkGuess(human);
            if (!isGuessed){
              game.checkGuess(computer);
      }
    }
   playTurn = game.playAgain(human, computer); //cuando el juego se acabe porque alguien adivinó, llamar a este método para preguntar si quiere jugar otra vez//
    }
  }

  //checar las respuestas//
  boolean checkGuess (Player player) {
    int guess = player.makeGuess();
    List <Integer> guesses = player.getGuesses();
    int totalGuesses = guesses.toArray().length;
    System.out.println("---" + player.getName() + "----" + "\n adivinó: " + guess);
    if (guess == targetNumber) {
      System.out.println(player.getName() + " ha ganado. Los historiales de adivinanza son:" + guesses);
      System.out.println("El total de intentos fue: " + totalGuesses);
      return true;
    } else if (guess < targetNumber) {
      System.out.println("Número muy pequeño. Intenta otra vez");
      return false;
    } else {
      System.out.println("El número es muy grande. Intenta otra vez");
      return false;
    }
  }
  //metodo play again tiene dos parametros, el player humano y el player computadora//
  boolean playAgain (Player human, Player computer){
    //preguntamos si quiere jugar otra vez//
    System.out.println("¿Otra partida? (s/n)");
    String response = scanner.nextLine();
    //si dice que sí//
    if (response.equals("s")) {
      //creamos nuevo targetNumber//
      targetNumber = random.nextInt(100);
      //métodos reset//
      human.reset();
      computer.reset();
      System.out.println("¡Nueva partida comenzada!");
      return true;
    } else {
      // si no, simplemente muestra mensaje//
      System.out.println("¡Nos vemos pronto!");
      return false;
    }
    }
  }




