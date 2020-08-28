package com.application.MyDaily.Dao.Note;

import org.springframework.data.jpa.repository.JpaRepository;

import com.application.MyDaily.model.Note;

public interface NoteDao extends JpaRepository<Note, Long> {
	Note findByName(String name);

}
