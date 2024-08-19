package org.example.springmvc.homecontroller.bai4;

import org.example.springmvc.model.bai4.MedicalDeclaration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/bai4")
public class ControllerBai4 {
    @GetMapping("/input")
    public ModelAndView inputForm() {
        ModelAndView modelAndView = new ModelAndView("bai4ToKhaiYTe");
        modelAndView.addObject("medical", new MedicalDeclaration());
        return modelAndView;
    }
}
