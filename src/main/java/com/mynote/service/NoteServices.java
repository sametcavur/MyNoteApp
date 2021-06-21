package com.mynote.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mynote.dao.NoteDao;
import com.mynote.entities.Note;

@Service
@Transactional
public class NoteServices {
	
	@Autowired
	private NoteDao dao;

	public void saveNotes(Note note) {
		dao.save(note);
	}
	public Note findNoteByObject(Note note) {
		Note notee = dao.find(note.getId());
		return notee;
	}
	public void updateNote(Note note) {
		dao.update(note);
	}
	public void deleteNotes(Note note) {
		dao.delete(note);
	}
	public List<Note> findAllNotes() {
		List<Note> notes = dao.findAllNotes();
		return notes;
	}
	public List<Note> findNotesByUserId(long userId) {
		List<Note> notes = dao.findNoteByUserId(userId);
		return notes;
	}
	public List<Note> findNotesByNoteId(long id) {
		List<Note> notes = dao.findNoteByNoteId(id);
		return notes;
	}
}
