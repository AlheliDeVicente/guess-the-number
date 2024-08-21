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
        //para cada guess, hace un nuevo número random//
        int guess = random.nextInt(100);
        //añade ese número random a la lista//
        guesses.add(guess);
        return guess;
    }
}


