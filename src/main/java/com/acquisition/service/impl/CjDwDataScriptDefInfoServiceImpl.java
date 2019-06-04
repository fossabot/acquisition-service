package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.entity.CjDwDataScriptDefInfoKey;
import com.acquisition.mapper.CjDataSourceTabInfoMapper;
import com.acquisition.mapper.CjDwDataScriptDefInfoMapper;
import com.acquisition.service.ICjDwDataScriptDefInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDwDataScriptDefInfoServiceImpl implements ICjDwDataScriptDefInfoService {

    @Resource(name="cjDwDataScriptDefInfoMapper")
    CjDwDataScriptDefInfoMapper cjDwDataScriptDefInfoMapper;

    @Override
    public String save(CjDwDataScriptDefInfo cjDwDataScriptDefInfo) {
        try {
            int insert = cjDwDataScriptDefInfoMapper.insert(cjDwDataScriptDefInfo);
            if(insert>0){
                return "保存成功";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "保存失败";
    }

    @Override
    public String deleteByPrimaryKey(CjDwDataScriptDefInfoKey key) {
        try{
            cjDwDataScriptDefInfoMapper.deleteByPrimaryKey(key);
        }catch (Exception e){
            e.printStackTrace();
            return "删除失败";
        }
        return "删除成功";
    }
    public String selectDdlInfo(String businessSystemNameShortName, String dataSourceSchema, String dataSourceTable) {
        return cjDwDataScriptDefInfoMapper.selectDdlInfo(
                businessSystemNameShortName,
                dataSourceSchema,
                dataSourceTable
        );
    }
}
