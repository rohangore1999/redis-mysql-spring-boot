package com.example.redis_mysql.repositories;

import com.example.redis_mysql.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// By extending JpaRepository, the NoteRepository interface inherits all these methods, so you don’t need to manually implement common database operations.
@Repository
public interface NoteRepository extends JpaRepository<Note, String> {
}
