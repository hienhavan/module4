package org.example.springmvc.repository;

import org.example.springmvc.model.bai8.Song;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SongB8Service extends JpaRepository<Song, Integer> {
}
