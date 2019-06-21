package com.acquisition.mapper;


import com.acquisition.entity.CjDataSourceUniqueIndexInfo;

import java.util.List;

public interface CjDataSourceUniqueIndexInfoMapper {


    int insertBatch(List<CjDataSourceUniqueIndexInfo> list);

    int deleteBatch(List<CjDataSourceUniqueIndexInfo> list);

}
