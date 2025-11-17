    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Scanner scan = new Scanner(System.in);
            MorseConverter mc = new MorseConverter();

            System.out.println("1) English → Morse");
            System.out.println("2) Morse → English");
            System.out.print("Choose: ");

            String choice = scan.nextLine();

            try {
                if (choice.equals("1")) {
                    System.out.print("Enter English text: ");
                    String input = scan.nextLine();
                    System.out.println("Morse: " + mc.toMorse(input));

                } else if (choice.equals("2")) {
                    System.out.print("Enter Morse code: ");
                    String input = scan.nextLine();
                    System.out.println("English: " + mc.toEnglish(input));

                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
