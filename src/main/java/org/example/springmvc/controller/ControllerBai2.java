package org.example.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/bai2")
public class ControllerBai2 {
    @GetMapping("/tinhToan")
    public String getChonNL() {
        return "bai2TinhToan";
    }

    @PostMapping("/hienThiTinhToan")
    public ModelAndView saveNL(@RequestParam("num1") double num1, @RequestParam("num2") double num2, @RequestParam("op") String op) {
        String rs = " ";
        try {
            switch (op) {
                case "+": rs="tong:"+ (num1+num2);
                    break;
                case "-": rs="hieu:"+ (num1-num2);
                    break;
                case "*": rs="tich:"+ (num1*num2);
                    break;
                case ":":
                    if (num2 == 0) {
                        rs="thuong:"+ (num1/num2);
                    }
                    else
                        rs="mau phai khac 0!";
                    break;
            }
        }

        catch (NumberFormatException e) {
            rs = "khong phai la so";
            System.out.println(rs);


        }
        ModelAndView result = new ModelAndView("bai2TinhToan");
        result.addObject("data", rs);
        return result;
    }

}
