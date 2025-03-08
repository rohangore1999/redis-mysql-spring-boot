package com.example.redis_mysql.services;

import com.example.redis_mysql.entities.Note;
import com.example.redis_mysql.repositories.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NoteService {
    @Autowired
    private NoteRepository noteRepository;

    // save
    // CachePut ->  update the cache with the latest data when a method is called.
    // while saving also we are putting this Note in "notes" region so that while doing get we will get through cache.
    @CachePut(value="notes", key="#note.id") // (which region, based on what we have to cache)
    public Note createNote(Note note){
        note.setId(UUID.randomUUID().toString());
        noteRepository.save(note);

        return note;
    }

    // getAll
    public List<Note> getAllNotes(){
        return noteRepository.findAll();
    }

    // get
    // to get from cache we use "@Cacheable"
    @Cacheable(value="notes", key="#noteId") // value -> cache name/region, key -> based on what we need to cache
    // we are storing Note in notes region. Also the Note should be serializable as we only store string data in redis
    public Note findNoteById(String noteId){
        return noteRepository.findById(noteId).orElseThrow(() -> new RuntimeException("Note with given id not found"));
    }

    // update
    public Note updateNote(Note note){
        Note fetchedNote = noteRepository.findById(note.getId()).orElseThrow(()-> new RuntimeException("Note with given id not found"));
        fetchedNote.setTitle(note.getTitle());
        fetchedNote.setContent(note.getContent());
        fetchedNote.setLive(note.isLive());

        return noteRepository.save(fetchedNote);
    }

    // delete
    @CacheEvict(value = "notes", key="#noteId")
    public void deleteNote(String noteId){
        // checking if the note exist
        Note fetchNote = noteRepository.findById(noteId).orElseThrow(()-> new RuntimeException("Note with given id not found"));

        noteRepository.delete(fetchNote);
    }
}

