    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            // Skapar scanner för att läsa användarens inmatning
            Scanner scan = new Scanner(System.in);
            // Skapar ett MorseConverter-objekt som gör själva översättningen
            MorseConverter mc = new MorseConverter();

            // Enkel meny för att välja konverteringsriktning
            System.out.println("1) English → Morse");
            System.out.println("2) Morse → English");
            System.out.print("Choose: ");
            
            String choice = scan.nextLine(); // Läser in användarens val

            try {
                if (choice.equals("1")) {
                    // Översätter engelsk text till morsekod
                    System.out.print("Enter English text: ");
                    String input = scan.nextLine();
                    System.out.println("Morse: " + mc.toMorse(input));

                } else if (choice.equals("2")) {
                    // Översätter morsekod till engelsk text
                    System.out.print("Enter Morse code: ");
                    String input = scan.nextLine();
                    System.out.println("English: " + mc.toEnglish(input));

                } else {
                    // Om användaren skriver något annat än 1 eller 2
                    System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                // Fångar fel, t.ex. ogiltiga tecken
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
