package com.acquisition.service.impl;

import com.acquisition.entity.CjDwDataScriptDefInfo;
import com.acquisition.mapper.CjDwDataScriptDefInfoMapper;
import com.acquisition.service.ICjDwDataScriptDefInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
}
