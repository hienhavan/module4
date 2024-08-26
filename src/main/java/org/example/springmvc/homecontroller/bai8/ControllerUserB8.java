package org.example.springmvc.homecontroller.bai8;

import org.example.springmvc.model.bai8.Contacts;
import org.example.springmvc.model.demo_bai_8.User;
import org.example.springmvc.services.bai8.Userb8Services;
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
public class ControllerUserB8 {
    @Autowired
    private Userb8Services userb8Services;

    @RequestMapping("/userForm")
    public String showUserPage(Model model) {
        model.addAttribute("contacts", new Contacts());
        return "userFromb8";
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute @Valid Contacts contacts, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "userFromb8";
        }
        userb8Services.saveUser(contacts);
        model.addAttribute("contacts", contacts);
        return "success";
    }
}
