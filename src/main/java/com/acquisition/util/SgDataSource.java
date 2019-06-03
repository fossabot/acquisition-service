package com.acquisition.util;

import com.acquisition.entity.CjDataSourceConnDefine;
import com.acquisition.entity.CjDataSourceConnDefineExample;
import com.acquisition.service.ICjDataSourceConnDefineService;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by zhangdongmao on 2019/3/9.
 */

/*@Component("SgDataSource")*/
public class SgDataSource implements DataSource {
    @Resource(name = "cjDataSourceConnDefineServiceImpl")
    ICjDataSourceConnDefineService cjDataSourceConnDefineService;
    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(SgDataSource.class);
    private static Map<String,List<Connection>> connectionMap=new HashMap<>();

    public SgDataSource(){
//        getConnections();
    }


    public void getConnections() {
        Connection conn;
        String driver="";
        String username;
        String password;
        String url="";
        String databaseType;
        String schema;
        String sysAbbreviation;
        int initialSize=3;
        List<CjDataSourceConnDefine> cjDataSourceConnDefines = cjDataSourceConnDefineService.selectByExample();
        for(CjDataSourceConnDefine cjDataSourceConnDefine:cjDataSourceConnDefines){
            username=cjDataSourceConnDefine.getLoginName();
            password=cjDataSourceConnDefine.getLoginPassword();
            databaseType=cjDataSourceConnDefine.getDataBaseType();
            if(cjDataSourceConnDefine.getDataSourceSchema().equals("-")){
                schema="";
            }else{
                schema=cjDataSourceConnDefine.getDataSourceSchema();
            }
            sysAbbreviation=cjDataSourceConnDefine.getBusinessSystemNameShortName()+schema;
            List<Connection> connectionList = new LinkedList<>();
            switch(databaseType){
                case "mysql":
                    driver="com.mysql.jdbc.Driver";
                    url="jdbc:mysql://"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort();
                    break;
                case "oracle":
                    driver="oracle.jdbc.OracleDriver";
                    url="jdbc:oracle:thin:@"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort()+":"+cjDataSourceConnDefine.getDbInstance();
                    break;
                case "sqlserver":
                    driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    url="jdbc:sqlserver://"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort();
                    break;
                case "hive":
                    driver="org.apache.hive.jdbc.HiveDriver";
                    url="jdbc:hive2://"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort()+"/"+cjDataSourceConnDefine.getHiveQueue();
                    break;
            }
            System.out.println(url);
            try {
                Class.forName(driver);
                for (int i = 0; i < initialSize; i++) {
                    conn = DriverManager.getConnection(url, username, password);
                    connectionList.add(conn);
                }
                connectionMap.put(sysAbbreviation, connectionList);
            }catch (Exception e){
                e.printStackTrace();
                LOGGER.error(e.toString());
            }
        }
        for(String key : connectionMap.keySet()){
            LOGGER.info(key+"系统连接个数:"+String.valueOf(connectionMap.get(key).size()));
        }
    }
    public Connection getConnection(String businessSystemNameShortName,String dataSourceSchema) throws SQLException {
        Connection conn = null;
        String sysAbbreviation=businessSystemNameShortName+dataSourceSchema;
        if(connectionMap.get(sysAbbreviation) == null || connectionMap.get(sysAbbreviation).size() <= 0){
            Connection connection = newConnection(businessSystemNameShortName,dataSourceSchema);
            connectionMap.get(sysAbbreviation).add(connection);
        }
        conn = connectionMap.get(sysAbbreviation).remove(0);
        return conn;
    }
    public Connection newConnection(String businessSystemNameShortName,String dataSourceSchema){
        Connection conn = null;
        String driver="";
        String username;
        String password;
        String url="";
        String databaseType;
        String sysAbbreviation=businessSystemNameShortName+dataSourceSchema;
        CjDataSourceConnDefineExample cjDataSourceConnDefineExample = new CjDataSourceConnDefineExample();
        CjDataSourceConnDefineExample.Criteria criteria = cjDataSourceConnDefineExample.createCriteria();
        criteria.andBusinessSystemNameShortNameEqualTo(businessSystemNameShortName);
        criteria.andDataSourceSchemaEqualTo(dataSourceSchema);
        CjDataSourceConnDefine cjDataSourceConnDefine = cjDataSourceConnDefineService.selectByExample(businessSystemNameShortName, dataSourceSchema);
        username=cjDataSourceConnDefine.getLoginName();
        password=cjDataSourceConnDefine.getLoginPassword();
        databaseType=cjDataSourceConnDefine.getDataBaseType();
        List<Connection> connectionList = new LinkedList<>();
        switch(databaseType){
            case "mysql":
                driver="com.mysql.jdbc.Driver";
                url="jdbc:mysql://"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort();
                break;
            case "oracle":
                driver="oracle.jdbc.OracleDriver";
                url="jdbc:oracle:thin:@"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort()+":"+cjDataSourceConnDefine.getDbInstance();
                break;
            case "sqlserver":
                driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
                url="jdbc:sqlserver://"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort();
                break;
            case "hive":
                driver="org.apache.hive.jdbc.HiveDriver";
                url="jdbc:hive2://"+cjDataSourceConnDefine.getConnIp()+":"+cjDataSourceConnDefine.getConnPort()+"/"+cjDataSourceConnDefine.getHiveQueue();
                break;
        }
        System.out.println(url);
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
            connectionList.add(conn);
            connectionMap.put(sysAbbreviation, connectionList);
        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error(e.toString());
        }
        return conn;
    }
    public void backConnection(String sysAbbreviation,Connection conn){
        connectionMap.get(sysAbbreviation).add(conn);
    }
    public static void free(ResultSet rst, PreparedStatement pst) {
        try {
            if (rst != null) {
                rst.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
    @Override
    public Connection getConnection() throws SQLException {
        return null;
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
