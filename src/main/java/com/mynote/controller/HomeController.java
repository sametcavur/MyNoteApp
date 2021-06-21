package com.mynote.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mynote.entities.Note;
import com.mynote.service.NoteServices;

@Controller
public class HomeController {
	@Autowired
	NoteServices noteServices;
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("notes",noteServices.findNotesByUserId(0L));
		return "home";
	}
	
	@RequestMapping(value = "/error404", method = RequestMethod.GET)
	public String error() {
		return "error404";
	}

	@RequestMapping(value = "/addnote", method = RequestMethod.GET)
	public String addnotes() {
		return "addnote";
	}
	
	@RequestMapping(value = "/addnote", method = RequestMethod.POST)
	public ResponseEntity<String> addNotes(@RequestBody Note note) {
		if(note.getContent() != null && note.getTitle() != null) {
			noteServices.saveNotes(note);	
			}
		else {
		System.out.println("HATA");
		}
		return new ResponseEntity<>("Notunuz Kaydedildi",HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getnotes", method = RequestMethod.POST)
	public ResponseEntity<List<Note>> getNotes() {
		return new ResponseEntity<>(noteServices.findNotesByUserId(0L) ,HttpStatus.CREATED);
	}
	
}
