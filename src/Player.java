import java.util.ArrayList;

public abstract class Player {
   public String name;
   protected ArrayList <Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<>();
    }


    //makeguess//
    public abstract int makeGuess();

    //getter público//
    public String getName() {
        return name;
    }

    //getter público//
    public ArrayList<Integer> getGuesses() {
        return guesses;
    }

}

