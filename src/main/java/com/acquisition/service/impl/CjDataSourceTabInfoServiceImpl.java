package com.acquisition.service.impl;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.Result;
import com.acquisition.mapper.CjDataSourceTabInfoMapper;
import com.acquisition.mapper.CjOdsCrtTabDdlInfoMapper;
import com.acquisition.service.ICjDataSourceTabInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public class CjDataSourceTabInfoServiceImpl implements ICjDataSourceTabInfoService {

    @Resource(name = "cjDataSourceTabInfoMapper")
    public CjDataSourceTabInfoMapper cjDataSourceTabInfoMapper;

    /**
     * @return 返回ODS中未创建的表
     */
    @Override
    public String findAllByColsAndOds() {
        return Result.ok(cjDataSourceTabInfoMapper.selectBySystemAndSchema());
    }

    /**
     * @param dataFlagForCrtOdsDll 已生成ODS DDL 1
     * @param dataFlagForCrtOdsHive ODS已建表 1
     * @return 返回更改状态
     */
    @Override
    public void updateODSFlg(String dataFlagForCrtOdsDll ,String dataFlagForCrtOdsHive) {
        cjDataSourceTabInfoMapper.updateDataFlagForCrtOdsDll(dataFlagForCrtOdsDll,dataFlagForCrtOdsHive);
    }

    @Override
    public List<CjDataSourceTabInfo> findAllByOdsHiveAndDwHive(String dataFlagForGetCols,String dataFlagForCrtOdsDll) {
        /*return cjDataSourceTableInfoRepository.selectAllByOdsHiveAndDwHive(dataFlagForGetCols,dataFlagForCrtOdsDll);*/
        return null;
    }

    @Override
    public void updcrtDwFlagByObject(CjDataSourceTabInfo cjDataSourceTabInfo) {

    }


}
