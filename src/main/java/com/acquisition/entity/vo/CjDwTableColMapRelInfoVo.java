package com.acquisition.entity.vo;

import com.acquisition.entity.CjDwTableColMapRelInfo;
import lombok.Data;

/**
 * Created by zhangdongmao on 2019/7/9.
 */
@Data
public class CjDwTableColMapRelInfoVo  extends CjDwTableColMapRelInfo {
    private String sourceTableComment;
    private String targetTableComment;

}
