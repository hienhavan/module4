package org.example.springmvc.homecontroller.minitest1;

import org.example.springmvc.model.minitest1.Tour;
import org.example.springmvc.model.minitest1.TourForm;
import org.example.springmvc.services.minitest1.ITourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.SystemException;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/minitest1")
public class ControllerMiniTest1 {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private ITourService service;

    @GetMapping
    public String showForm(Model model) {
        List<Tour> list = service.findAll();
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        service.remove(id);
        return "redirect:/minitest1";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("tourForm", new TourForm());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveProduct(@ModelAttribute TourForm tourForm) throws SystemException {
        MultipartFile multipartFile = tourForm.getImg();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(tourForm.getImg().getBytes(), new File(fileUpload + fileName));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Tour tour = new Tour(tourForm.getId(), tourForm.getCode(),
                tourForm.getDestination(), tourForm.getStart(), fileName);
        service.save(tour);

        return "redirect:/minitest1";
    }
}
