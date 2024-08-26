package org.example.springmvc.homecontroller.bai8;

import org.example.springmvc.model.bai8.Contacts;
import org.example.springmvc.model.bai8.Song;
import org.example.springmvc.services.bai8.SongB8Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/bai8")
public class ControllerSongs {
    @Autowired
    private SongB8Services  userb8Services;
    @RequestMapping("/SongForm")
    public String showUserPage(Model model) {
        model.addAttribute("song", new Song());
        return "songFromb8";
    }

    @PostMapping("/submitFormSong")
    public String submitForm(@ModelAttribute @Valid Song song, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "songFromb8";
        }
        userb8Services.addSong(song);
        model.addAttribute("song", song);
        return "successSong";
    }
}
