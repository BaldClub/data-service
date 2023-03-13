package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

/**
 * 菌房实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_room")
public class DataBacterialRoom extends BaseDomain {

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 菌房名称
     */
    private String name;

    /**
     * 菌房位置
     */
    private String location;

}
