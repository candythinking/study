package com.candy.controller;

import com.candy.model.tb_dataComplete;
import com.candy.service.DemoColumnService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
@Controller
public class DemoController {

    @RequestMapping("/demo")
    public String demo(Model model) {

       List<tb_dataComplete> a = DemoColumnService.getCloumnData();
        String[] citys = new String[a.size()];
        String[] dataSums = new String[a.size()];
        String[] defaultValues = new String[a.size()];

        int i = 0;
        for(tb_dataComplete t : a){
            citys[i] = t.getCity();
            dataSums[i] = t.getDataSum();
            defaultValues[i] = t.getDefaultValue();
            i++;
//            System.out.println(t);
        }
        model.addAttribute("citys",citys);
        model.addAttribute("dataSums",dataSums);
        model.addAttribute("defaultValues",defaultValues);
        return "demo";
    }
}
