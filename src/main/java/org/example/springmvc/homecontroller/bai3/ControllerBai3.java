package org.example.springmvc.homecontroller.bai3;

import org.example.springmvc.model.UserDTO;
import org.example.springmvc.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class ControllerBai3 {
    @Autowired
    private UserServices userService;

    @GetMapping("/showUser")
    public ModelAndView showUser() {
        ModelAndView modelAndView = new ModelAndView("bai3ListUser");
        List<UserDTO> listUsers = new ArrayList<UserDTO>();
        listUsers = userService.showList();
        modelAndView.addObject("listUsers", listUsers);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/user/showUser";
    }

    @GetMapping("/formAddUser")
    public String addUser() {
        return "bai3AddUser";
    }

    @PostMapping("/addUser")
    public String addUser(@RequestParam("email") String email, @RequestParam("password") String password) {
        UserDTO user = new UserDTO();
        user.setEmail(email);
        user.setPassword(password);
        userService.addUser(user);
        return "redirect:/user/showUser";
    }
}
