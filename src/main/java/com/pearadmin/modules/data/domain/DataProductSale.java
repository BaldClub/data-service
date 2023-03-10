package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 产品销售实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_product_sale")
public class DataProductSale extends BaseDomain {

    /**
     * 产品销售编号
     */
    @TableId
    private String id;

    /**
     * 售出时间
     */
    private LocalDate time;

    /**
     * 产品编号
     */
    private String productId;

}
