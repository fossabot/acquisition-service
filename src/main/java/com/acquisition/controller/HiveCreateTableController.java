package com.acquisition.controller;

import com.acquisition.entity.*;
import com.acquisition.entity.pojo.CjDwCrtDdlColPojo;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjDwCrtTabDdlInfoService;
import com.acquisition.util.*;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import com.acquisition.util.Result;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yili.pool.pool.GroupPoolFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/hiveCreateTable")
public class HiveCreateTableController {

    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    public ICjDataSourceTabColInfoService cjDataSourceTabColInfoService;

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    public ICjDataSourceTabInfoService cjDataSourceTabInfoService;

    @Resource(name = "cjOdsCrtTabDdlInfoServiceImpl")
    public ICjOdsCrtTabDdlInfoService cjOdsCrtTabDdlInfoService;

    @Resource(name = "cjDwCrtTabDdlInfoServiceImpl")
    public ICjDwCrtTabDdlInfoService cjDwCrtTabDdlInfoService;

    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/5
    * @Description:  获取DW建表页面筛选列表
    * @Param: * @param null 1
    * @return:
    */
    @GetMapping(value = "/getDWSystemAndSchemaFilterList")
    public Result getDWSystemAndSchemaFilterList(){
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findDistSystemAndSchemaFromCjVGetPrepareCrtDwTabList();
        Set<String> systemSet = new HashSet<>();
        List<SystemSchemaFilterEntity> systemSchemaFilterEntities=new ArrayList<>();
        Result result=new Result();
        Map<String,List<String>> systemSchemaMap=new HashMap<>();
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            systemSet.add(cjDataSourceTabInfo.getBusinessSystemNameShortName());
        }
        Iterator<String> it = systemSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
            systemSchemaMap.put(str,new ArrayList<>());
        }
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            systemSchemaMap.get(cjDataSourceTabInfo.getBusinessSystemNameShortName()).add(cjDataSourceTabInfo.getDataSourceSchema());
        }
        for (String key : systemSchemaMap.keySet()) {
            SystemSchemaFilterEntity systemSchemaFilterEntity=new SystemSchemaFilterEntity();
            systemSchemaFilterEntity.setBusinessSystemNameShortName(key);
            systemSchemaFilterEntity.setDataSourceSchemas(systemSchemaMap.get(key));
            systemSchemaFilterEntities.add(systemSchemaFilterEntity);
        }
        return result.success(systemSchemaFilterEntities);
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/5
    * @Description: 获取ODS建表页面筛选列表
    * @Param: * @param null 1
    * @return:
    */
    @GetMapping(value = "/getODSSystemAndSchemaFilterList")
    public Result getODSSystemAndSchemaFilterList(){
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findDistSystemAndSchemaFromCjVGetPrepareCrtOdsTabList();
        Set<String> systemSet = new HashSet<>();
        List<SystemSchemaFilterEntity> systemSchemaFilterEntities=new ArrayList<>();
        Result result=new Result();
        Map<String,List<String>> systemSchemaMap=new HashMap<>();
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            systemSet.add(cjDataSourceTabInfo.getBusinessSystemNameShortName());
        }
        Iterator<String> it = systemSet.iterator();
        while (it.hasNext()) {
            String str = it.next();
            systemSchemaMap.put(str,new ArrayList<>());
        }
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            systemSchemaMap.get(cjDataSourceTabInfo.getBusinessSystemNameShortName()).add(cjDataSourceTabInfo.getDataSourceSchema());
        }
        for (String key : systemSchemaMap.keySet()) {
            SystemSchemaFilterEntity systemSchemaFilterEntity=new SystemSchemaFilterEntity();
            systemSchemaFilterEntity.setBusinessSystemNameShortName(key);
            systemSchemaFilterEntity.setDataSourceSchemas(systemSchemaMap.get(key));
            systemSchemaFilterEntities.add(systemSchemaFilterEntity);
        }
        return result.success(systemSchemaFilterEntities);
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/5
    * @Description:  DW建表页面筛选查询
    * @Param: * @param null 1
    * @return:
    */

    @PostMapping(value = "/getDWCreateTabListByFilter")
    public Result getDWCreateTabListByFilter(@RequestBody PageGeorge<List<String>> reqParams){
        Result result=new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findFromCjVGetPrepareCrtDwTabListBySystemAndSchema(reqParams.getQuery().get(0),reqParams.getQuery().get(1));
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        result.setMsg("查询成功");
        return result.success(page);
    }
    /**
    * @Author: zhangdongmao
    * @Date: 2019/6/5
    * @Description:  ODS建表页面筛选查询
    * @Param: * @param null 1
    * @return:
    */
    @PostMapping(value = "/getODSCreateTabListByFilter")
    public Result getODSCreateTabListByFilter(@RequestBody Page reqParams){
        Result result=new Result();
        System.out.println(reqParams.getQuery());
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findFromCjVGetPrepareCrtOdsTabListBySystemAndSchema(reqParams.getQuery().get(0), reqParams.getQuery().get(1));
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        return result.success(page);
    }
    @GetMapping(value = "/getDWCreateTabList")
    public Result getDWCreateTabList(Page reqParams) {
        Result result=new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService
                .findAllCjVGetPrepareCrtDwTabList();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);

        return result.success(page);
    }

    @PostMapping(value = "/dWCreateTable")
    public Result dWCreateTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        data = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(data, CjDataSourceTabInfo.class);
        String businessSystemNameShortName;
        String dataSourceSchema;
        String dataSourceTable;
        String dwTableName;
        String colName;
        String colType;
        String colComment;
        Result result=new Result();
//        //遍历每张表，生成DW建表语句
        for (CjDataSourceTabInfo cjDataSourceTabInfo:cjDataSourceTabInfos){
            businessSystemNameShortName=cjDataSourceTabInfo.getBusinessSystemNameShortName();
            dataSourceSchema=cjDataSourceTabInfo.getDataSourceSchema();
            dataSourceTable=cjDataSourceTabInfo.getDataSourceTable();
            dwTableName="d_nct_"+dataSourceSchema.toLowerCase()+"_"+dataSourceTable.toLowerCase();
            //使用StringBuffer拼接DW建表语句
            StringBuffer dwddl=new StringBuffer();
            dwddl.append("create table if not exists acquisition_dw."+dwTableName+"\n");
            dwddl.append("("+"\n");
            //通过系统名、数据模式、表名获取表的字段信息
            List<CjDwCrtDdlColPojo> cjDwCrtDdlColPojos = cjDataSourceTabColInfoService.selectCjDwCrtDdlColPojoBySysAndSchemaAndTab(businessSystemNameShortName, dataSourceSchema, dataSourceTable);
            for(int i=0;i<cjDwCrtDdlColPojos.size();i++){
                colName=cjDwCrtDdlColPojos.get(i).getDataSourceColName().toLowerCase();
                colComment=cjDwCrtDdlColPojos.get(i).getDataSourceColComment();
                if(colComment==null){
                    colComment="";
                }
                //判断colName中是否包含中文，若包含，则colName转为全拼，源colName赋值给colComment
                Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
                Matcher m = p.matcher(colName);
                if (m.find()) {
                    colComment=colName;
                    colName=PinyinUtil.getPinYin(colName);
                }
                colType=cjDwCrtDdlColPojos.get(i).getColMapper().toLowerCase();
                dwddl.append("    `"+colName+"`    "+colType+"    "+"comment '"+colComment+"'"+",\n");
            }
            dwddl.append("    `src_sys_row_id`    string    comment '源系统pk',\n");
            dwddl.append("    `src_sys_cd`    string    comment '源系统代码',\n");
            dwddl.append("    `src_table_name`    string    comment '源系统pk',\n");
            dwddl.append("    `etl_dt`    string    comment '源表名',\n");
            dwddl.append("    `data_dt`    string    comment 'etl处理时间'\n");
            dwddl.append(")"+"\n");
            dwddl.append("row format delimited fields terminated by '\\001' lines terminated by '\\n' stored as orc");


            /**
             * 将dw建表语句存入mysql中
             */

            CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo=new CjDwCrtTabDdlInfo();
            cjDwCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjDwCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjDwCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjDwCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjDwCrtTabDdlInfo.setOdsDataTable(businessSystemNameShortName.toLowerCase()+"_"+dataSourceTable.toLowerCase());
            cjDwCrtTabDdlInfo.setDwDataTable(dwTableName);
            cjDwCrtTabDdlInfo.setDwDataTableDdlInfo(dwddl.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjDwCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            GroupPoolFactory instance = GroupPoolFactory.getInstance("DATALAKE-");
            Connection connection=null;
            PreparedStatement preparedStatement=null;
            try {
                connection = instance.getConnection();
                preparedStatement = connection.prepareStatement(dwddl.toString());
                preparedStatement.execute();
                cjDwCrtTabDdlInfoService.deleteByPrimaryKey(cjDwCrtTabDdlInfo);
                if(cjDwCrtTabDdlInfoService.save(cjDwCrtTabDdlInfo).equals("保存成功")){
                    //生成DW建表语句成功，设置状态表中的相应状态字段
                    cjDataSourceTabInfo.setDataFlagForCrtDwDll(Constant.DW_CRT_DDL);
                    cjDataSourceTabInfo.setDataFlagForCrtDwHive(Constant.DW_CRT_HIVE);
                    //将状态改变更新到数据库
                    CjDataSourceTabInfoExample cjDataSourceTabInfoExample=new CjDataSourceTabInfoExample();
                    CjDataSourceTabInfoExample.Criteria criteria = cjDataSourceTabInfoExample.createCriteria();
                    //where条件使用业务系统缩写、数据模式和表名做限制
                    criteria.andBusinessSystemNameShortNameEqualTo(businessSystemNameShortName);
                    criteria.andDataSourceSchemaEqualTo(dataSourceSchema);
                    criteria.andDataSourceTableEqualTo(dataSourceTable);
                    cjDataSourceTabInfoService.updateByExampleSelective(cjDataSourceTabInfo,cjDataSourceTabInfoExample);
                }
                dwddl.setLength(0);
            } catch (Exception e) {
                e.printStackTrace();
                dwddl.setLength(0);
                return result.error(500,"建表失败");
            }finally {
                if (connection != null) {
                    try {
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        result.setCode(200);
        result.setMsg("建表成功");
        return result;
    }

    /**
     * @return 返回已经导入清单，但没有在ODS建表的表
     */
    @RequestMapping(value = "/getODSTableInfo")
    @ResponseBody
    public Result getODSTable(PageGeorge reqParams) {
        Result result=new Result();
        PageHelper.startPage(reqParams.getPagenum(),reqParams.getPagesize());
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = cjDataSourceTabInfoService.findAllByColsAndOds();
        PageInfo<CjDataSourceTabInfo> page = new PageInfo<>(cjDataSourceTabInfos);
        return result.success(page);
    }

    /**
     * @return 获取前端传来的需要去ODS创建的表信息
     */
    @PostMapping("/createODSTable")
    public Result createODSTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("params");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        return saveDDLAndCreateTable(cjDataSourceTabInfos);
    }

    /**
     * @return 拼接并保存SQL,返回状态码
     */
    public Result saveDDLAndCreateTable(List<CjDataSourceTabInfo> CjDataSourceTabInfos) {
        String colName = "";
        String colComment = "";
        StringBuffer odsDDL = new StringBuffer();
        Result result=new Result();

        CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();

        //遍历从前端获取到表的列表，拼接字段，创建 Hive DDL
        for (CjDataSourceTabInfo cjDataSourceTabInfo : CjDataSourceTabInfos) {
            odsDDL.append("create table if not exists acquisition_ods."
                    + cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase()
                    + "_" + cjDataSourceTabInfo.getDataSourceTable().toLowerCase() + "\n");
            odsDDL.append("(" + "\n");

            List<CjDataSourceTabColInfo> infoList = cjDataSourceTabColInfoService
                    .findBySystemAndSchemaAndTab(cjDataSourceTabInfo.getBusinessSystemNameShortName(),
                            cjDataSourceTabInfo.getDataSourceSchema(),
                            cjDataSourceTabInfo.getDataSourceTable());
            for (int i = 0; i < infoList.size(); i++) {
                colName = infoList.get(i).getDataSourceColName().toLowerCase();
//                System.out.println(infoList.size());
//                System.out.println(colName);
                colComment = infoList.get(i).getDataSourceColComment();
                if (colComment == null) {
                    colComment = "";
                }
                if (i < infoList.size() - 1) {
                    odsDDL.append("    `" + colName + "`    " + "string" + "    " + "comment '" + colComment + "'" + ",\n");
                } else {
                    odsDDL.append("    `" + colName + "`    " + "string" + "    " + "comment '" + colName + "'" + "\n");
                }
            }
            odsDDL.append(")" + "\n");
            odsDDL.append("row format delimited fields terminated by '\\001' lines terminated by '\\n'");

            System.out.println(odsDDL);
            GroupPoolFactory instance = GroupPoolFactory.getInstance("DATALAKE-");
            Connection connection=null;
            PreparedStatement preparedStatement=null;
            try {
                connection = instance.getConnection();
                preparedStatement = connection.prepareStatement(odsDDL.toString());
                preparedStatement.execute();

                cjOdsCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
                cjOdsCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
                cjOdsCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
                cjOdsCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
                cjOdsCrtTabDdlInfo.setOdsDataSchema("sdata_full");
                cjOdsCrtTabDdlInfo.setOdsDataTable(cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase() + "_"
                        + cjDataSourceTabInfo.getDataSourceTable().toLowerCase());
                cjOdsCrtTabDdlInfo.setOdsDataTableDdlInfo(odsDDL.toString());
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                cjOdsCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
                cjOdsCrtTabDdlInfo.setLastModifyBy("admin");
                if (cjOdsCrtTabDdlInfoService.saveDDLAndCreateTable(cjOdsCrtTabDdlInfo)){
                    cjDataSourceTabInfoService.updateODSFlg(
                            "1","1",
                            cjDataSourceTabInfo.getBusinessSystemNameShortName(),
                            cjDataSourceTabInfo.getDataSourceSchema(),
                            cjDataSourceTabInfo.getDataSourceTable());
                }
                odsDDL.setLength(0);
            }catch (Exception e){
                e.printStackTrace();
                odsDDL.setLength(0);
                return result.error(500,"ODS建表失败！！！");
            }finally {
                if (connection != null) {
                    try {
                        preparedStatement.close();
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        result.setMsg("ODS建表成功！！！");
        result.setCode(200);
        return result;
    }
}
