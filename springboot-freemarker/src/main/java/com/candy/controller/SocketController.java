package com.candy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocketController {
    /*@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        model.addAttribute("datas", DemoColumnService.getCloumnData());
        return "hello";
    } */

    @RequestMapping("/socket")
    public String socket() {
        return "socketdemo";
    }
}
