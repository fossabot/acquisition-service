package com.acquisition.entity.vo;

import com.acquisition.entity.CjDwTableMapRelInfo;
import lombok.Data;

import java.util.List;

/**
 * Created by zhangdongmao on 2019/7/9.
 */
@Data
public class DwModelAndMapRel {
    private List<CjDwTableMapRelInfo> cjDwTableMapRelInfos;
    private List<CjDwTableColMapRelInfoVo> cjDwTableColMapRelInfoVos;
}
