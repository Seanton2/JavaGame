import java.util.Scanner;

public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getValidInt(int min, int max) {
        while (true) {
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                if (choice >= min && choice <= max) {
                    return choice;
                }
            } else {
                scanner.nextLine(); // clear invalid input
            }
            System.out.print("Invalid choice. Try again (" + min + "-" + max + "): ");
        }
    }

    public String getNextLine() {
        return scanner.nextLine();
    }
}