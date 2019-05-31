package com.acquisition.controller;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjOdsCrtTabDdlInfo;
import com.acquisition.entity.Result;
import com.acquisition.service.ICjDataSourceTabColInfoService;
import com.acquisition.service.ICjDataSourceTabInfoService;
import com.acquisition.service.ICjOdsCrtTabDdlInfoService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


/**
 * Created by zhangdongmao on 2019/5/29.
 */
@RestController
@RequestMapping(value = "/hiveCreateTable")
public class HiveCreateTableController {

    @Resource(name = "cjDataSourceTabInfoServiceImpl")
    ICjDataSourceTabInfoService iCjDataSourceTabInfoService;
    @Resource(name = "cjDataSourceTabColInfoServiceImpl")
    ICjDataSourceTabColInfoService iCjDataSourceTabColInfoService;
    @Resource(name = "cjOdsCrtTabDdlInfoServiceImpl")
    ICjOdsCrtTabDdlInfoService iCjOdsCrtTabDdlInfoService;

    /**
     * @return 返回已经导入清单，但没有在ODS建表的表
     */
    @RequestMapping(value = "/getODSTable")
    @ResponseBody
    public String getODSTable() {
        return iCjDataSourceTabInfoService.findAllByColsAndOds();
    }

    /**
     * @return 获取前端传来的需要去ODS创建的表信息
     */
    @PostMapping("/createODSTable")
    public String createODSTable(@RequestBody String data) {
        JSONObject jsonObject = JSONObject.parseObject(data);
        String odsTableList = jsonObject.getString("data");
        List<CjDataSourceTabInfo> cjDataSourceTabInfos = JSONObject.parseArray(odsTableList, CjDataSourceTabInfo.class);
        saveDDLAndCreateTable(cjDataSourceTabInfos);
        return Result.ok("sucess");
    }

    public String saveDDLAndCreateTable(List<CjDataSourceTabInfo> CjDataSourceTabInfos) {
        String colName = "";
        String colComment = "";
        StringBuffer odsDDL = new StringBuffer();
        CjOdsCrtTabDdlInfo cjOdsCrtTabDdlInfo = new CjOdsCrtTabDdlInfo();

        //遍历从前端获取到表的列表，拼接字段，创建 Hive DDL
        for (CjDataSourceTabInfo cjDataSourceTabInfo : CjDataSourceTabInfos) {
            odsDDL.append("create table is not exists sdata_full."
                    + cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase()
                    + "_" + cjDataSourceTabInfo.getDataSourceSchema().toLowerCase() + "\n");
            odsDDL.append("(" + "\n");

            List<CjDataSourceTabColInfo> infoList = iCjDataSourceTabColInfoService
                    .findBySystemAndSchema(cjDataSourceTabInfo.getBusinessSystemNameShortName(),
                            cjDataSourceTabInfo.getDataSourceSchema(),
                            cjDataSourceTabInfo.getDataSourceTable());

            for (int i = 0; i < infoList.size(); i++) {
                colName = infoList.get(i).getDataSourceColName().toLowerCase();
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

            cjOdsCrtTabDdlInfo.setBusinessSystemId(cjDataSourceTabInfo.getBusinessSystemId());
            cjOdsCrtTabDdlInfo.setBusinessSystemNameShortName(cjDataSourceTabInfo.getBusinessSystemNameShortName());
            cjOdsCrtTabDdlInfo.setDataSourceSchema(cjDataSourceTabInfo.getDataSourceSchema());
            cjOdsCrtTabDdlInfo.setDataSourceTable(cjDataSourceTabInfo.getDataSourceTable());
            cjOdsCrtTabDdlInfo.setOdsDataSchema("sdata_full");
            cjOdsCrtTabDdlInfo.setOdsDataTable(cjDataSourceTabInfo.getBusinessSystemNameShortName().toLowerCase() + "_" + cjDataSourceTabInfo.getDataSourceTable().toLowerCase());
            cjOdsCrtTabDdlInfo.setOdsDataTableDdlInfo(odsDDL.toString());
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            cjOdsCrtTabDdlInfo.setLastModifyDt(df.format(new Date()));
            cjOdsCrtTabDdlInfo.setLastModifyBy("admin");

            //保存DDL
            if (iCjOdsCrtTabDdlInfoService.saveDDLAndCreateTable(cjOdsCrtTabDdlInfo)){
                iCjDataSourceTabInfoService.updateODSFlg("1","1");
            }
            odsDDL.setLength(0);
        }
        return createTableInHive();
    }


    /**
     * 在Hive中建表
     *
     * @return 返回创建成功的状态
     */
    public String createTableInHive() {
        return Result.ok("Hive 表创建成功！");
    }
}
