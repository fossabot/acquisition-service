package com.acquisition;

import java.sql.*;

/**
 * Created by zhangdongmao on 2019/6/4.
 */
public class HiveTest {
    public static void main(String[] args) {
        String driverName ="org.apache.hive.jdbc.HiveDriver";   // 此Class 位于 hive-jdbc的jar包下
        String Url="jdbc:hive2://10.30.140.27:7777/";    //填写hive的IP，之前在配置文件中配置的IP
        Connection conn;

        {
            try
            {
                String sql="show tables";
                conn = DriverManager.getConnection(Url, "hive", "hive");
                Class.forName(driverName);
                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                ResultSet rset = preparedStatement.executeQuery();
                while (rset.next()) {
                    System.out.println(rset.getString(1));
                }
            }
            catch(ClassNotFoundException e)  {
                e.printStackTrace();
                System.exit(1);
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
//        public static PreparedStatement prepare(Connection conn, String sql) {
//            PreparedStatement ps = null;
//            try {
//                ps = conn.prepareStatement(sql);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            return ps;
//        }
    }
}
