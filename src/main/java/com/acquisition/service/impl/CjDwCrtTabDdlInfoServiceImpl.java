package com.acquisition.service.impl;

import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfoExample;
import com.acquisition.entity.CjDwCrtTabDdlInfoKey;
import com.acquisition.mapper.CjDwCrtTabDdlInfoMapper;
import com.acquisition.service.CjDwCrtTabDdlInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDwCrtTabDdlInfoServiceImpl implements CjDwCrtTabDdlInfoService {

    @Resource(name = "cjDwCrtTabDdlInfoMapper")
    public CjDwCrtTabDdlInfoMapper cjDwCrtTabDdlInfoMapper;

    @Override
    public int insertBatch(List<CjDwCrtTabDdlInfo> cjDwCrtTabDdlInfos) {
        cjDwCrtTabDdlInfoMapper.deleteBatch(cjDwCrtTabDdlInfos);
        return cjDwCrtTabDdlInfoMapper.insertBatch(cjDwCrtTabDdlInfos);
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

    @Override
    public String findOdsDataTableByDwDataTable(String dwDataTable) {
        return cjDwCrtTabDdlInfoMapper.selectOdsDataTableByDwDataTable(dwDataTable);
    }

    @Override
    public CjDwCrtTabDdlInfo findByDwDataTable(String dwDataTable) {
        return cjDwCrtTabDdlInfoMapper.selectByDwDataTable(dwDataTable);
    }

    @Override
    public int saveByOne(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo) {
        return cjDwCrtTabDdlInfoMapper.insertByOne(cjDwCrtTabDdlInfo);
    }

}
