import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = new Scanner(System.in);
    }

    @Override
    public int makeGuess() {
        System.out.print("Ingresa tu suposición: ");
        int guess = scanner.nextInt();
        guesses.add(guess);
        return guess;
    }
}


