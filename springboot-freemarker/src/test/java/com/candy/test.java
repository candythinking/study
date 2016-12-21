package com.candy;

import com.candy.model.tb_dataComplete;
import com.candy.service.DemoColumnService;

import java.util.List;

/**
 * Created by Administrator on 2016/12/20.
 */
public class test {
    public static void main(String[] args) {
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
    }
}
