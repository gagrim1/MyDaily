package com.application.MyDaily.Dao.Note;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.application.MyDaily.Exceptions.ValidationException;
import com.application.MyDaily.model.Note;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class NoteDaoImpl implements NoteService {
	
	private final NoteDao noteDao;
	
	void validateNote(Note note) throws ValidationException{
		if(note == null) {
			throw new ValidationException("Object user is null!");
		}
		if((note.getName() == null) || (note.getName().isEmpty())){
			throw new ValidationException("Username is empty.");
		}
	}

	@Override
	public Note findByName(String name) {
		Note note = noteDao.findByName(name);
		if(note != null) {
			return note;
		}
		return null;
	}

	@Override
	public Note save(Note note) {
		try {
			validateNote(note);
			noteDao.save(note);
			return note;
		}catch(ValidationException e) {
			e.printStackTrace();
			return note;
		}
	}

	@Override
	public List<Note> findAll() {
		return noteDao.findAll()
				.stream()
				.collect(Collectors.toList());
	}

	@Override
	public void deleteNote(Long id) {
		noteDao.deleteById(id);
		
	}

}
