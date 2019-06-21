package com.acquisition.service;

import com.acquisition.entity.CjDataSourceUniqueIndexInfo;
import java.util.List;

/**
 * 源系统数据表唯一索引信息
 */
public interface CjDataSourceUniqueIndexInfoService {

    int insertBatch(List<CjDataSourceUniqueIndexInfo> list);
}

