import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.util.Scanner;

public class HumanPlayerTest {

    @Test
    public void testMakeGuess() {
        //se mockea el scanner//
        Scanner mockScanner = mock(Scanner.class);
       //el mock se configura tal para que el scanner ponga 7 como la respuesta del usuario//
        when(mockScanner.nextInt()).thenReturn(7);
        //spy del humanPayer //
        HumanPlayer spyHumanPlayer = spy(new HumanPlayer("Human", mockScanner));

        //se llama al método makeguess para comprobar que dentro del metodo makeguess hay un scanner, un nextInt y que el siete en efecto se añade//
        spyHumanPlayer.makeGuess();
        verify(mockScanner).nextInt();
        assertTrue(spyHumanPlayer.getGuesses().contains(7));
    }
}
