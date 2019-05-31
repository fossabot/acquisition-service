package com.acquisition.service;

import com.acquisition.entity.CjDataSourceTabInfo;
import com.acquisition.entity.CjDwCrtTabDdlInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/5/29.
 */
@Service
public interface ICjDwCrtTabDdlInfoService {
    String createDwTable(List<CjDataSourceTabInfo> cjDataSourceTabInfoList);
    void insertByObject(CjDwCrtTabDdlInfo cjDwCrtTabDdlInfo);

}
