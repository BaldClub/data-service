package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

/**
 * 菌包实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_bag")
public class DataBacterialBag extends BaseDomain {

    /**
     * 菌包编号
     */
    @TableId
    private String id;

    /**
     * 菌房编号
     */
    private String bacterialRoomId;

    /**
     * 菌包品种 (平菇、香菇、茶树菇、木耳、金针菇、杏鲍菇)
     */
    private String type;

}
