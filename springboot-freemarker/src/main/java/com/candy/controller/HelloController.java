package com.candy.controller;

import com.candy.service.DemoColumnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
    /*@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        model.addAttribute("datas", DemoColumnService.getCloumnData());
        return "hello";
    } */

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("datas", DemoColumnService.getCloumnData());
        return "hello";
    }
}
