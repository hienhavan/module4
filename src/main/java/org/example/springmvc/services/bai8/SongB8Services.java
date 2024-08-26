package org.example.springmvc.services.bai8;

import org.example.springmvc.model.bai8.Song;
import org.example.springmvc.repository.SongB8Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SongB8Services {
    @Autowired
    private SongB8Service service;

    public void addSong(Song song) {
        service.save(song);
    }
}
