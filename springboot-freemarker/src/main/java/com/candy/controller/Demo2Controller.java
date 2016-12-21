package com.candy.controller;

import com.candy.model.tb_dataComplete;
import com.candy.service.DemoColumnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class Demo2Controller {
    /*@RequestMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        model.addAttribute("datas", DemoColumnService.getCloumnData());
        return "hello";
    } */

    @RequestMapping("/demo2")
    public String hello() {

        return "index";
    }
    @RequestMapping("/json")
    @ResponseBody
    public Map<String,Object> json(){
        Map<String,Object> map = new HashMap<String,Object>();
        List<tb_dataComplete> a = DemoColumnService.getCloumnData();
        List<String> citysList = new ArrayList<String>();
        List<Integer> dataSumsList = new ArrayList<Integer>();
        List<Integer> defaultValuesList = new ArrayList<Integer>();
        for(tb_dataComplete t : a){
            citysList.add(t.getCity());
            dataSumsList.add(Integer.parseInt(t.getDataSum()));
            defaultValuesList.add(Integer.parseInt(t.getDefaultValue()));
//            System.out.println(t);
        }
        map.put("citys",citysList);
        map.put("dataSums",dataSumsList);
        map.put("defaultValues",defaultValuesList);
        return map;
    }


}
