package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 菌房设备实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_room_device")
public class DataBacterialRoomDevice extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 菌房编号 */
    private Long bacterialRoomId;

    /** 设备类型 */
    private String type;


}
