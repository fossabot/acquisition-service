package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfoExample;
import com.acquisition.entity.CjDwCrtTabDdlInfoKey;
import com.acquisition.mapper.CjDwCrtTabDdlInfoMapper;
import com.acquisition.service.ICjDwCrtTabDdlInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDwCrtTabDdlInfoServiceImpl implements ICjDwCrtTabDdlInfoService{

    @Resource(name = "cjDwCrtTabDdlInfoMapper")
    public CjDwCrtTabDdlInfoMapper cjDwCrtTabDdlInfoMapper;

    private final static Logger LOGGER = LoggerFactory.getLogger(CjDwCrtTabDdlInfoServiceImpl.class);

    @Override
    public String save(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo) {

        try {
            int insert = cjDwCrtTabDdlInfoMapper.insert(cjDwCrtTabDdlInfo);
            if(insert>0){
                return "保存成功";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return "保存失败";
    }

    @Override
    public String updateByExampleSelective(CjDwCrtTabDdlInfo record,CjDwCrtTabDdlInfoExample example) {
        try {
            int i = cjDwCrtTabDdlInfoMapper.updateByExampleSelective(record, example);
            if(i>0){
                return "更新成功";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "更新失败";
    }


    @Override
    public String deleteByPrimaryKey(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo) {
        CjDwCrtTabDdlInfoKey cjDwCrtTabDdlInfoKey=new CjDwCrtTabDdlInfoKey();
        cjDwCrtTabDdlInfoKey.setBusinessSystemNameShortName(cjDwCrtTabDdlInfo.getBusinessSystemNameShortName());
        cjDwCrtTabDdlInfoKey.setDataSourceSchema(cjDwCrtTabDdlInfo.getDataSourceSchema());
        cjDwCrtTabDdlInfoKey.setDataSourceTable(cjDwCrtTabDdlInfo.getDataSourceTable());
        cjDwCrtTabDdlInfoKey.setDwDataTable(cjDwCrtTabDdlInfo.getDwDataTable());
        cjDwCrtTabDdlInfoKey.setOdsDataTable(cjDwCrtTabDdlInfo.getOdsDataTable());
        try {
            int i = cjDwCrtTabDdlInfoMapper.deleteByPrimaryKey(cjDwCrtTabDdlInfoKey);
            if(i>0){
                return "删除成功";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "删除失败";
    }


}
