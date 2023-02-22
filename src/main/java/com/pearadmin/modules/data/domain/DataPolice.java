package com.pearadmin.modules.data.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 报警实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_police")
public class DataPolice extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 报警类型 (环境报警, 生产报警, 设备报警, 农资农事报警, 监控报警) */
    private String type;

    /** 时间 */
    private Date time;


}
