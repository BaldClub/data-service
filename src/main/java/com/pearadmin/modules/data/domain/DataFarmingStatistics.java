package com.pearadmin.modules.data.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 农事统计实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_farming_statistics")
public class DataFarmingStatistics extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 农事类型 (采摘, 病虫害防治, 菌包上下架) */
    private String type;

    /** 次数 */
    private Long count;

    /** 时间 */
    private Date time;


}
