package org.example.springmvc.model.bai8;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotBlank(message = "Tên bài hát không được phép để trống")
    @Size(max = 800, message = "Tên bài hát không vượt quá 800 ký tự")
    @Pattern(regexp = "^[^@;,\\.\\-=+]+$", message = "Tên bài hát không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Column(name = "song_title")
    private String songTitle;

    @NotBlank(message = "Nghệ sĩ thể hiện không được phép để trống")
    @Size(max = 300, message = "Nghệ sĩ thể hiện không vượt quá 300 ký tự")
    @Pattern(regexp = "^[^@;,\\.\\-=+]+$", message = "Nghệ sĩ thể hiện không chứa các kí tự đặc biệt như @ ; , . = - + , ….")
    @Column(name = "artist")
    private String artist;

    @NotBlank(message = "Thể loại nhạc không được phép để trống")
    @Size(max = 1000, message = "Thể loại nhạc không vượt quá 1000 ký tự")
    @Pattern(regexp = "^[^@;\\.\\-=+]+$", message = "Thể loại nhạc không chứa các kí tự đặc biệt ngoại trừ dấu phẩy \",\".")
    @Column(name = "genre")
    private String genre;

    public Song() {
    }

    public Song(int id, String songTitle, String artist, String genre) {
        this.id = id;
        this.songTitle = songTitle;
        this.artist = artist;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
