package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfoExample;
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
        if(cjDwCrtTabDdlInfoMapper.insert(cjDwCrtTabDdlInfo)>0){
            return "插入成功";
        }
        return "插入失败";
    }

    @Override
    public String updateByExampleSelective(CjDwCrtTabDdlInfo record,CjDwCrtTabDdlInfoExample example) {
        if(cjDwCrtTabDdlInfoMapper.updateByExampleSelective(record,example)>0){
            return "更新成功";
        }
        return "更新失败";
    }

}
