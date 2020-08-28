package com.application.MyDaily.Dao.Note;

import java.util.List;

import com.application.MyDaily.model.Note;

public interface NoteService {
    Note findByName(String name);
    Note save(Note note);
    List<Note> findAll();
    void deleteNote(Long id);
}
