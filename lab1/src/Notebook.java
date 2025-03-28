import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

class Notebook {
    private List<Note> notes = new ArrayList<>();

    // Створення нотатки
    public void addNote(String title, String content) {
        notes.add(new Note(title, content));
        System.out.println("Нотатку додано.");
    }

    // Читання всіх нотаток
    public void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("номер: " + i + "\n" + notes.get(i) + "\n");
            }
        }
    }

    // Оновлення нотатки
    public void updateNote(int index, String newTitle, String newContent) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setTitle(newTitle);
            notes.get(index).setContent(newContent);
            System.out.println("Нотатку оновлено.");
        } else {
            System.out.println("Невірний номер нотатки.");
        }
    }

    // Видалення нотатки
    public void deleteNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Нотатку видалено.");
        } else {
            System.out.println("Невірний номер нотатки.");
        }
    }

    // 🔽 Сортування нотаток за назвою
    public void sortNotesByTitle() {
        Collections.sort(notes, Comparator.comparing(Note::getTitle));
        System.out.println("Нотатки відсортовано за назвою.");
    }



    public void searchNotes(String query) {
        List<Note> searchResult = new ArrayList<>();
        for (Note note : notes) {
            if (fieldContainsQuery(note.getTitle(), query) || fieldContainsQuery(note.getContent(), query)) {
                searchResult.add(note);
            }
        }

        if (searchResult.isEmpty()) {
            System.out.println("Нічого не знайдено.");
        } else {
            System.out.println("Результати пошуку:");
            for (Note note : searchResult) {
                System.out.println(note + "\n");
            }
        }
    }

    private boolean fieldContainsQuery(String field, String query) {
        return field.toLowerCase(Locale.getDefault()).contains(query.toLowerCase(Locale.getDefault()));
    }

}
