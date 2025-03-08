package com.example.redis_mysql.controllers;

import com.example.redis_mysql.entities.Note;
import com.example.redis_mysql.services.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/note")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @GetMapping("/get/{id}")
    public Note getNoteById(@PathVariable String id){
        return noteService.findNoteById(id);
    }

    @GetMapping("/get-all")
    public List<Note> getNotes(String id){
        return noteService.getAllNotes();
    }

    @PostMapping("/create")
    public Note createNote(@RequestBody Note note){
        return noteService.createNote(note);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNote(@PathVariable String id){
        noteService.deleteNote(id);

        return "Note with id " + id + " deleted";
    }
}
