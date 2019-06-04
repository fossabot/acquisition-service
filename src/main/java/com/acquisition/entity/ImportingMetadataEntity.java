package com.acquisition.entity;

import lombok.Data;

/**
 * @author yxk
 * @Description: 导入数据实体
 * @create 2019/6/3
 * @since 1.0.0
 */
@Data
public class ImportingMetadataEntity {
    private String owner;
    private String table_name;
    private String tab_comments;
    private String column_name;
    private String column_id;
    private String primarykey;
    private String isnullflag;
    private String data_type;
    private String data_length;
    private String data_precision;
    private String data_scale;
    private String col_comment;
}
