import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

//ByteArrar es clase que nos permite capturar los datos que normmalmente irian a la consolan, es un arreglo de bytes del cual después se puede sacar información//
//printstrem es lo que nos permite mandar esos datos a un lugar de saida, que puede ser la consola o el bytearray en neustro caso//

class GuessTheNumberGameTest {
    private Player player; //atributo//
    private GuessTheNumberGame game; //atributo//
    private int testTargetNumber = 10; //atributo//
    private final ByteArrayOutputStream consoleMessage = new ByteArrayOutputStream(); // nuevo objeto atributo//

    //método que debe ejecutarse antes de cada test, en este caso el voidsetup se ejecuta antes de cada instancia de test//
    @BeforeEach
    void setUp() { //configura el entorno de prueba, crea objetos y demás que se vayan a usar en las pruebas siguientes//
        player = mock(Player.class); //mockear la clase//
        game = new GuessTheNumberGame(); //nuevo objeto//
        game.targetNumber = testTargetNumber; // el atributo targetNumber  de game es igual al atributo definido arriba//
        System.setOut(new PrintStream(consoleMessage)); // mandar lo que se supone que va a la consola al bytearray mediante print stram//
    }


    @Test
    //cuando la respuesta sea correcta...//
    // se configura el funcionamiento del mock//
    void testCheckGuess_CorrectGuess() {
        //le digo que cuando haga un guess, arroje el targetNumber definido acá//
        when(player.makeGuess()).thenReturn(testTargetNumber);
        //cuando se llame al método getName, arroje jugador 1//
        when(player.getName()).thenReturn("Jugador 1");
        // cuando llame al método getguesses, arroje un ArrayList de Integer
        when(player.getGuesses()).thenReturn(new ArrayList<>(Arrays.asList(testTargetNumber)));
        //le digo que result es pues el resultado de llamar el método checkGuess con el argumento de player//, entiendo yo que es que se checkee el guess player de cierto jugador//
        boolean result = game.checkGuess(player);
        // le digo que ese result debe ser verdadero, pues en checkguess lo guardamos así//
        assertTrue(result);
        // si es verdadero, makeguess debe ser invocado una vez en checkguess//
        verify(player, times(1)).makeGuess();
        // guetguesses una vez//
        verify(player, times(1)).getGuesses();
        //getName dos veces (lineas 37 y 39)//
        verify(player, times(2)).getName();
        String consoleOutput = consoleMessage.toString().trim();
        assertTrue(consoleOutput.contains("Jugador 1 ha ganado. Los historiales de adivinanza son:[10]"));
    }

    @Test
    // cuando la respuesta es incorrecta y el número es más bajo///
    void testCheckGuess_IncorrectGuess_Lower() {
        // le digo que es el target number -1 para cuando llame al método makeGyess//
        when(player.makeGuess()).thenReturn(testTargetNumber - 1);
        when(player.getName()).thenReturn("Jugador 1");
        // el valor de game.checkGuess se guarda en variable booleana//
        boolean result = game.checkGuess(player);
        //variable es falsa pq adivinó mal//
        assertFalse(result);
        //llamada de cada método es solo una vez//
        verify(player, times(1)).makeGuess();
        verify(player, times(1)).getName();
        verify(player, times(1)).getGuesses();
        // pasar lo que tenemos en el ByteArray a string//
        String consoleOutput = consoleMessage.toString().trim();
        //asegurarnos que en efecto ambos mensajes sean lo mismo//
        assertTrue(consoleOutput.contains("Número muy pequeño. Intenta otra vez"));
    }

    @Test
    //lo mismo pero ahora para cuando es incorrecto y más alto//
    void testCheckGuess_incorrectGuess_Higher() {
        when(player.makeGuess()).thenReturn(testTargetNumber + 1);
        when(player.getName()).thenReturn("Jugador 1");
        boolean result = game.checkGuess(player);
        assertFalse(result);
        verify(player, times(1)).makeGuess();
        verify(player, times(1)).getName();
        verify(player, times(1)).getGuesses();
        String consoleOutput = consoleMessage.toString().trim();
        assertTrue(consoleOutput.contains("El número es muy grande. Intenta otra vez"));
    }

    @Test
    //test para la función de PlayAgain//
   public void testPlayAgain_yes(){
        //mockear el scanner para yo darle la funcioalidad que quiero//
        Scanner mockScanner = mock(Scanner.class);
        //retorne la S para cuando quiero volver a jugar//
        when(mockScanner.nextLine()).thenReturn("s");
        // primero creo un objeto jugador humano//
        Player realhuman = new HumanPlayer("Human", mockScanner);
        //traigo acá el scanner pa' que corran las pruebas//
        game.setScanner(mockScanner);
        // al objeto jugador humano lo espio//
        Player human = spy(realhuman);
        //acá igual//
        Player realcomputer = new ComputerPlayer();
        Player computer = spy(realcomputer);
        //llamo al método playagain y lo guardo en variable booleana//
        boolean result = game.playAgain(human, computer);
        assertTrue(result);
        //que cuando sea verdadero se llame al método reset//
        verify(human).reset();
        verify(computer).reset();
    }
    @Test
    public void testPlayAgain_no(){
        Scanner mockScanner = mock(Scanner.class);
        when(mockScanner.nextLine()).thenReturn("n");
        Player realhuman = new HumanPlayer("Human", mockScanner);
        game.setScanner(mockScanner);
        Player human = spy(realhuman);
        Player realcomputer = new ComputerPlayer();
        Player computer = spy(realcomputer);
        boolean result = game.playAgain(human, computer);
        assertFalse(result);
        //acá que se verifique el mensaje de la consola//
        String consoleOutput = consoleMessage.toString().trim();
        assertTrue(consoleOutput.contains("¡Nos vemos pronto!"));
}
@Test
    void playTurn(){
        GuessTheNumberGame game = mock(GuessTheNumberGame.class);
        Player human = mock(Player.class);
        Player computer = mock(Player.class);
        when(game.checkGuess(human)).thenReturn(false);
        when(game.checkGuess(computer)).thenReturn(false);
        when(game.playAgain(human, computer)).thenReturn(false);
        boolean playTurn = true;
        while(playTurn){
            boolean isGuessed = false;
            while ((!isGuessed)){
               isGuessed = game.checkGuess(human);
               if (!isGuessed){
                   game.checkGuess(computer);
               }
            }
            playTurn = game.playAgain(human, computer);
        }
        verify(game, times(1)).checkGuess(human);
        verify(game, times(1)).checkGuess(computer);
        verify(game, times(2)).playAgain(human, computer);
}
}


