import java.util.Random;

public class ComputerPlayer extends Player {
    private Random random;

    public ComputerPlayer() {
        super("Computer");
        random = new Random(100);
    }
z
    @Override
    public int makeGuess() {
        return random.nextInt(100);
    }
}


