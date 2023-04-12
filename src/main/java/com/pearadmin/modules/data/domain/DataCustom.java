package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 自定义数据实体
 *
 * @author leo
 * @date 2023-04-12
 */
@Data
@TableName("data_custom")
public class DataCustom extends BaseDomain {

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 页面名称
     */
    private String pageName;

    /**
     * 数据
     */
    private String data;

}
