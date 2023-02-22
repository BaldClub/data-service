package com.pearadmin.modules.data.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 菌包实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_bag_environment")
public class DataBacterialBagEnvironment extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 空气温度 (摄氏度) */
    private Long temperature;

    /** 空气湿度 (%) */
    private Long humidity;

    /** PH值 */
    private Long ph;

    /** 时间 */
    private Date time;


}
