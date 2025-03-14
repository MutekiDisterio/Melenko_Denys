import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Головний клас
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notebook notebook = new Notebook();
        boolean running = true;

        while (running) {
            System.out.println("Введіть команду 1(для створення)");
            System.out.println("Введіть команду 2(для списку)");
            System.out.println("Введіть команду 3(для оновлення)");
            System.out.println("Введіть команду 4(для видалення)");
            System.out.println("Введіть команду 5(щоб вийти)");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "1":
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter content: ");
                    String content = scanner.nextLine();
                    notebook.addNote(title, content);
                    break;
                case "2":
                    notebook.listNotes();
                    break;
                case "3":
                    System.out.print("Enter index of note to update: ");
                    int updateIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new content: ");
                    String newContent = scanner.nextLine();
                    notebook.updateNote(updateIndex, newTitle, newContent);
                    break;
                case "4":
                    System.out.print("Enter index of note to delete: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    notebook.deleteNote(deleteIndex);
                    break;
                case "5":
                    running = false;
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Unknown command!");
                    break;
            }
        }
        scanner.close();
    }
}
