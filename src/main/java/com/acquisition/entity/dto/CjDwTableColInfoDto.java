package com.acquisition.entity.dto;

import com.acquisition.entity.CjDwTableColInfo;
import lombok.Data;

/**
 * Created by zhangdongmao on 2019/7/3.
 */
@Data
public class CjDwTableColInfoDto extends CjDwTableColInfo {
    private String targetTableColName;
}
