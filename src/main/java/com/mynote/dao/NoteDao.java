package com.mynote.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mynote.entities.Note;

@Repository
public class NoteDao{
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyNoteApplication");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	
	public void save(Note note) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(note);
		entityTransaction.commit();
	}

	public void update(Note note) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Note notes = entityManager.find(Note.class, note.getId());
		entityManager.merge(notes);
		entityTransaction.commit();
	}
	
	public Note find(long noteId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Note note = entityManager.find(Note.class,noteId);
		entityTransaction.commit();
		return note;
	}
	
	public void delete(Note note) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.remove(note);
		entityTransaction.commit();
	}
	public List<Note> findAllNotes() {
		String query = "SELECT n FROM Note n WHERE ORDER BY desc";
		TypedQuery<Note> notes =entityManager.createQuery(query, Note.class);
		List<Note> notess = notes.getResultList();
		return notess;
	}
	public List<Note> findNoteByUserId(long userId) {
		String query = "SELECT n FROM Note n WHERE userId=:userId ORDER BY id desc";
		TypedQuery<Note> notes =entityManager.createQuery(query, Note.class);
		notes.setParameter("userId", userId);
		List<Note> notess = notes.getResultList();
		return notess;
	}
	public List<Note> findNoteByNoteId(long id) {
		String query = "SELECT n FROM Note n WHERE id=:id";
		TypedQuery<Note> notes =entityManager.createQuery(query, Note.class);
		notes.setParameter("id",id);
		List<Note> notess = notes.getResultList();
		return notess;
	}

}
