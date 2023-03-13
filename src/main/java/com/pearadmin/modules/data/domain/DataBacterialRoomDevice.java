package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

/**
 * 菌房设备实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_room_device")
public class DataBacterialRoomDevice extends BaseDomain {

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 菌房编号
     */
    private String bacterialRoomId;

    /**
     * 设备类型
     */
    private String type;

}
