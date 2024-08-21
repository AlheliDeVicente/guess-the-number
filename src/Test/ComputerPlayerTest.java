import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ComputerPlayerTest {
    private ComputerPlayer computerPlayer;
    //se ejecuta antes de cada uno de los test en una clase de prueba//
    @BeforeEach
    // corre antes de cualquier invocación de los tests, sirve para inicializar objetos (como el constructor (?)
    void setUp() {
        //creación de nuevo objeto de la clase computerplayer//
        computerPlayer = new ComputerPlayer();
    }

    @Test
    void makeGuess() {
        //se declara nueva variable guess, se accede al método makeguess del objeto player//
        int guess = computerPlayer.makeGuess();
        //que guess sea mayor igual a cero o menor igual a diez//
        assertTrue(guess>=0 && guess <=100);
    }
}