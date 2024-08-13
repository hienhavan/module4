package org.example.springmvc.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@org.springframework.stereotype.Controller
@RequestMapping("/bai1")
public class Controller {

    @GetMapping("/formTinhToan")
    public String getFormTinhToan() {
        return "bai1ChuyenDoiTien";
    }

    @PostMapping("/tinhToan")
    public ModelAndView calculate(@RequestParam("money") double money, @RequestParam("op") String op) {
        String rs = " ";
        int conversionParValue = 24000;
        try {
            switch (op) {
                case "vnd":
                    rs = "vnd:" + (money * conversionParValue);
                    break;
                case "usd":
                    rs = "usd:" + (money / conversionParValue);
                    break;
            }
        } catch (NumberFormatException e) {
            rs = "khong phai la so";
            System.out.println(rs);
        }
        ModelAndView modelAndView = new ModelAndView("bai1ChuyenDoiTien");
        modelAndView.addObject("result", rs);
        return modelAndView;
    }


    @GetMapping("/formTuDien")
    public String getTuDien() {
        return "bai1TuDien";
    }

    @PostMapping("/tudien")
    public ModelAndView translate(@RequestParam("word") String word) {
        String rs = " ";
        ModelAndView modelAndView = new ModelAndView("bai1TuDien");
        Map<String, Object> attributes = new HashMap<String, Object>();
        attributes.put("trang", "zhuang");
        attributes.put("tu", "banana");
        attributes.put("tao", "apple");
        for (String key : attributes.keySet()) {
            if (key.equalsIgnoreCase(word)) {
                rs = (String) attributes.get(key);
                break;
            } else {
                rs = "khong tim thay tu";
            }
        }
        modelAndView.addObject("result", rs);
        return modelAndView;
    }
}
