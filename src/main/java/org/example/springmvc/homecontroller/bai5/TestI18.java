package org.example.springmvc.homecontroller.bai5;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/testI18")
public class TestI18 {
    @GetMapping
    public String index() {
        return "testI18";
    }
}
