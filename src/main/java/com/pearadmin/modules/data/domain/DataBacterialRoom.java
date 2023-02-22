package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 菌房实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_room")
public class DataBacterialRoom extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 菌房名称 */
    private String name;

    /** 菌房位置 */
    private String location;


}
