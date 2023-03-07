package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;


/**
 * 产品溯源扫码数据实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_product_trace_scan")
public class DataProductTraceScan extends BaseDomain {

    /**
     * 产品溯源扫码数据编号
     */
    @TableId
    private String id;

    /**
     * 时间
     */
    private LocalDate time;

    /**
     * 产品编号
     */
    private String productId;
}
