import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// Клас для управління нотатками
class Notebook {
    private List<Note> notes = new ArrayList<>();

    // Створення нотатки
    public void addNote(String title, String content) {
        notes.add(new Note(title, content));
        System.out.println("Note added successfully.");
    }

    // Читання всіх нотаток
    public void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("Index: " + i + "\n" + notes.get(i) + "\n");
            }
        }
    }

    // Оновлення нотатки
    public void updateNote(int index, String newTitle, String newContent) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setTitle(newTitle);
            notes.get(index).setContent(newContent);
            System.out.println("Note updated successfully.");
        } else {
            System.out.println("Invalid note index.");
        }
    }

    // Видалення нотатки
    public void deleteNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("Invalid note index.");
        }
    }
}
