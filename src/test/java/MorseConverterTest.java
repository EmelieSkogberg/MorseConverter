import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MorseConverterTest {

    MorseConverter mc = new MorseConverter();

    @Test
    void testSingleLetter() {
        assertEquals(".-", mc.toMorse("A"));
    }

    @Test
    void testWordToMorse() {
        assertEquals(".... . .-.. .-.. ---", mc.toMorse("HELLO"));
    }

    @Test
    void testMorseToEnglish() {
        assertEquals("SOS", mc.toEnglish("... --- ..."));
    }

    @Test
    void testInvalidEnglishCharacter() {
        assertThrows(IllegalArgumentException.class, () -> mc.toMorse("A!"));
    }

    @Test
    void testInvalidMorseCode() {
        assertThrows(IllegalArgumentException.class, () -> mc.toEnglish("..--"));
    }
}