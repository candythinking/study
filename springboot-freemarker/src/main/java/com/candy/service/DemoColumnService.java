package com.candy.service;

import com.candy.model.tb_dataComplete;
import com.candy.utils.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/12/16.
 */
public class DemoColumnService {
    private static String searchSQL = "select city,sum(datasum)as datasum,sum(defaultvalue)as defaultvalue from tb_dataComplete group by city order by defaultvalue desc";
//    private static String searchSQL = "select * from tb_dataComplete limit 10";
    private static Connection connection = JDBCTools.openDB();

    public static List<tb_dataComplete> getCloumnData(){
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<tb_dataComplete> l = new ArrayList<tb_dataComplete>();
        try {
            preparedStatement = connection.prepareStatement(searchSQL);
            resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            while (resultSet.next()){
                tb_dataComplete tdc = new tb_dataComplete();

                /*tdc.setRegionCode(resultSet.getString("regionCode"));
                tdc.setId(resultSet.getLong("id"));*/
                tdc.setCity(resultSet.getString("city"));
                tdc.setDataSum(resultSet.getString("datasum"));
                tdc.setDefaultValue(resultSet.getString("defaultvalue"));
                l.add(tdc);
                System.out.println(tdc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return l;
    }

    public static void main(String[] args){
        getCloumnData();
    }
}
