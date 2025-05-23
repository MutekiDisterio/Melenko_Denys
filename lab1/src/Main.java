import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Notebook notebook = new Notebook();

        notebook.loadFromFile();


        boolean running = true;

        while (running) {
            System.out.println("Введіть команду 1(для створення)");
            System.out.println("Введіть команду 2(для списку)");
            System.out.println("Введіть команду 3(для оновлення)");
            System.out.println("Введіть команду 4(для видалення)");
            System.out.println("Введіть команду 5(для сортування за назвою)");
            System.out.println("Введіть команду 6(для пошуку по назві або вмісту)");
            System.out.println("Введіть команду 7(щоб вийти)");
            String command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "1":
                    System.out.print("Введіть назву: ");
                    String title = scanner.nextLine();
                    System.out.print("Введіть вміст: ");
                    String content = scanner.nextLine();
                    notebook.addNote(title, content);
                    notebook.saveToFile();
                    break;
                case "2":
                    notebook.listNotes();
                    break;
                case "3":
                    System.out.print("Введіть номер нотатки для редагування: ");
                    int updateIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Введіть нову назву: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Введіть новий вміст: ");
                    String newContent = scanner.nextLine();
                    notebook.updateNote(updateIndex, newTitle, newContent);
                    notebook.saveToFile();
                    break;
                case "4":
                    System.out.print("Введіть номер нотатки щоб видалити її: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    notebook.deleteNote(deleteIndex);
                    notebook.saveToFile();
                    break;
                case "5":
                    notebook.sortNotesByTitle();
                    break;
                case "6":
                    System.out.print("Введіть текст для пошуку: ");
                    String searchQuery = scanner.nextLine();
                    notebook.searchNotes(searchQuery);
                    break;

                case "7":
                    running = false;
                    System.out.println("Програма закрита.");
                    break;
                default:
                    System.out.println("Невідома команда");
                    break;
            }
        }
        scanner.close();
    }
}