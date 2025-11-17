public class MorseConverter {
    private static final String[] LETTERS = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y", "Z"
};

    private static final String[] MORSE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    /** ENG → MORSE */
    public String toMorse(String text) {
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c == ' ') continue; // ignorera mellanslag

            int index = c - 'A';
            if (index < 0 || index > 25)
                throw new IllegalArgumentException("Invalid character: " + c);

            if (result.length() > 0) result.append(" ");
            result.append(MORSE[index]);
        }
        return result.toString();
    }

    /** MORSE → ENG */
    public String toEnglish(String morse) {
        StringBuilder result = new StringBuilder();
        String[] tokens = morse.trim().split("\\s+");

        for (String token : tokens) {
            boolean found = false;

            for (int i = 0; i < MORSE.length; i++) {
                if (MORSE[i].equals(token)) {
                    result.append(LETTERS[i]);
                    found = true;
                    break;
                }
            }
            if (!found)
                throw new IllegalArgumentException("Invalid morse code: " + token);
        }
        return result.toString();
    }
}
