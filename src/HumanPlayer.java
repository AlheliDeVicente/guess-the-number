import java.util.Scanner;

public class HumanPlayer extends Player {
    Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }
    //se lee la suposición de la usuaria y se añade a la lista de suposiciones//
    @Override
    public int makeGuess() {
        System.out.print("Ingresa tu suposición: ");
        int guess = scanner.nextInt();
        scanner.nextLine();
        guesses.add(guess);
        return guess;
    }
}


