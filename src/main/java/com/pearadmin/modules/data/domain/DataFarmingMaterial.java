package com.pearadmin.modules.data.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 农事材料实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_farming_material")
public class DataFarmingMaterial extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 类型 (原材料购买, 原材料消耗, 能源消耗, 药品消耗) */
    private String type;

    /** 价格 */
    private Long price;

    /** 时间 */
    private Date time;


}
