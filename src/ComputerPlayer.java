import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer() {
        super("Computer");
        random = new Random();
    }
    //computadora crea un número aleatorio y lo añade a la lista//
    @Override
    public int makeGuess() {
        int guess = random.nextInt(100);
        guesses.add(guess);
        return guess;
    }
}


