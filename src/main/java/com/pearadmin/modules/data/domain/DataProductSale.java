package com.pearadmin.modules.data.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 产品销售实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_product_sale")
public class DataProductSale extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 售出时间 */
    private Date time;

    /** 产品编号 */
    private Long productId;


}
