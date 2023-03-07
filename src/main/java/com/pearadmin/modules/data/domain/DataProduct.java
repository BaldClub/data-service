package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

/**
 * 产品实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_product")
public class DataProduct extends BaseDomain {

    /**
     * 产品编号
     */
    @TableId
    private String id;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 产品售价
     */
    private Double price;
}
