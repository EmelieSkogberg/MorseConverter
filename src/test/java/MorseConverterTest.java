import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseConverterTest {
    
    // Skapar ett objekt av MorseConverter som används i alla tester
    MorseConverter mc = new MorseConverter();

    @Test
    void testSingleLetter() {
        // Testar att en enskild bokstav översätts korrekt
        assertEquals(".-", mc.toMorse("A"));
    }

    @Test
    void testWordToMorse() {
        // Testar att ett helt ord översätts till korrekt morsekod
        assertEquals(".... . .-.. .-.. ---", mc.toMorse("HELLO"));
    }

    @Test
    void testMorseToEnglish() {
        // Testar att morsekod kan översättas tillbaka till vanlig text
        assertEquals("SOS", mc.toEnglish("... --- ..."));
    }

    @Test
    void testInvalidEnglishCharacter() {
        // Kontroll att programmet kastar fel om texten innehåller ogiltiga tecken
        assertThrows(IllegalArgumentException.class, () -> mc.toMorse("A!"));
    }

    @Test
    void testInvalidMorseCode() {
        // Kontroll att ogiltig morsekod ger ett felmeddelande (exception)
        assertThrows(IllegalArgumentException.class, () -> mc.toEnglish("..--"));
    }
}
