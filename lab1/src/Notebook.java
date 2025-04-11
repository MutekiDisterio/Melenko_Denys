import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;

class Notebook {
    private final List<Note> notes = new ArrayList<>();
    private final String FILE_NAME = "notes.json";

    public void addNote(String title, String content) {
        notes.add(new Note(title, content));
        System.out.println("Нотатку додано.");
    }

    public void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("Немає нотаток.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("номер: " + (i+1) + "\n" + notes.get(i) + "\n");
            }
        }
    }

    public void updateNote(int index, String newTitle, String newContent) {
        if (index >= 0 && index < notes.size()) {
            notes.get(index).setTitle(newTitle);
            notes.get(index).setContent(newContent);
            System.out.println("Нотатку оновлено.");
        } else {
            System.out.println("Невірний номер нотатки.");
        }
    }

    public void deleteNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Нотатку видалено.");
        } else System.out.println("Невірний номер нотатки.");
    }

    public void sortNotesByTitle() {
        notes.sort(Comparator.comparing(Note::getTitle));
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
    public void saveToFile() {
        try (Writer writer = new FileWriter(FILE_NAME)) {
            Gson gson = new Gson();
            gson.toJson(notes, writer);
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
    public void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (Reader reader = new FileReader(file)) {
            Gson gson = new Gson();
            Type listType = new TypeToken<List<Note>>() {}.getType();
            List<Note> loadedNotes = gson.fromJson(reader, listType);
            if (loadedNotes != null) {
                notes.clear();
                notes.addAll(loadedNotes);
            }
        } catch (IOException e) {
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}