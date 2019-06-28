package com.acquisition.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by zhangdongmao on 2019/6/27.
 */
public class CreateTableUtil {

    public static String getOdsTableName(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable){
        String odsTableName=businessSystemNameShortName.toLowerCase()+ "_" +dataSourceSchema.toLowerCase()+"_"+ dataSourceTable.toLowerCase();
        //判断表名中是否包含中文，若包含，则odsTableName转为全拼
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(odsTableName);
        if (m.find()) {
            odsTableName=PinyinUtil.getPinYin(odsTableName);
        }
        return odsTableName;
    }

    public static String getDwTableName(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable){
        String dwTableName="d_nct_"+businessSystemNameShortName.toLowerCase()+ "_" +dataSourceSchema.toLowerCase()+"_"+ dataSourceTable.toLowerCase();
        //判断表名中是否包含中文，若包含，则dwTableName转为全拼
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(dwTableName);
        if (m.find()) {
            dwTableName=PinyinUtil.getPinYin(dwTableName);
        }
        return dwTableName;
    }
}
