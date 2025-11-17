public class MorseConverter {
    // Lista över bokstäver A–Z i rätt ordning
    // Positionen i listan matchar index i MORSE-arrayen
    private static final String[] LETTERS = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
        "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
        "U", "V", "W", "X", "Y", "Z"
};

    // Motsvarande morsekod för varje bokstav ovan
    // Ex: LETTERS[0] = "A", MORSE[0] = ".-"
    private static final String[] MORSE = {
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

     /**
     * Översätter engelsk text till morsekod.
     * Accepterar endast bokstäver A–Z.
     *
     * @param text vanlig text som ska översättas
     * @return morsekod som en sträng
     */
    public String toMorse(String text) {
        // Gör texten versal
        text = text.toUpperCase();
        StringBuilder result = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (c == ' ') continue; // ignorera mellanslag

            // Omvandlar bokstav → index i alfabetet
            int index = c - 'A';
            // Kontroll att tecknet är en giltig bokstav
            if (index < 0 || index > 25)
                throw new IllegalArgumentException("Invalid character: " + c);

            // Lägg till mellanrum mellan morse-tecken
            if (result.length() > 0) result.append(" ");
             // Hämta motsvarande morsekod
            result.append(MORSE[index]);
        }
        return result.toString();
    }

    /**
     * Översätter morsekod till engelsk text.
     * Ex: ".-" → "A"
     *
     * @param morse text i morsekod
     * @return engelsk text
     */
    public String toEnglish(String morse) {
        StringBuilder result = new StringBuilder();
        // Delar upp morsekoden per tecken, separerade med mellanslag
        String[] tokens = morse.trim().split("\\s+");

        for (String token : tokens) {
            boolean found = false;

            // Letar efter matchande morsekod
            for (int i = 0; i < MORSE.length; i++) {
                if (MORSE[i].equals(token)) {
                    result.append(LETTERS[i]);
                    found = true;
                    break;
                }
            }
            // Om ingen match hittas → felaktig input
            if (!found)
                throw new IllegalArgumentException("Invalid morse code: " + token);
        }
        return result.toString();
    }
}
