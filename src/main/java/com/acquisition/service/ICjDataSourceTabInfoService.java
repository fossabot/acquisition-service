package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabColInfo;
import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDataSourceTabInfoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjDataSourceTabInfoService {
    List<CjDataSourceTabInfo> findAllByOdsHiveAndDwHive(String dataFlagForGetCols,String dataFlagForCrtOdsDll);
    String updateByExampleSelective(CjDataSourceTabInfo record, CjDataSourceTabInfoExample example);
    String findAllByColsAndOds(String dataFlagForGetCols, String dataFlagForCrtOdsDll);
}
