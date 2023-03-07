package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 产品投诉实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_product_complain")
public class DataProductComplain extends BaseDomain {

    /**
     * 产品投诉编号
     */
    @TableId
    private String id;

    /**
     * 投诉时间
     */
    private LocalDate time;

    /**
     * 投诉内容
     */
    private String content;

    /**
     * 投诉产品编号
     */
    private String productId;
}
