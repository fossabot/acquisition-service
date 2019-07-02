package com.acquisition.ipcTest;

/**
 * Created by zhangdongmao on 2019/3/25.
 */
public class Main {
    public static void main(String[] args) {
        String s="int(2,10)";
        String[] split = s.split(",");
        System.out.println(split[1].replace(")", ""));
    }
}
