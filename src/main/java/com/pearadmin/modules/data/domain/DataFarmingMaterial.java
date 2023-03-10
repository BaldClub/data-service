package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 农事材料实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_farming_material")
public class DataFarmingMaterial extends BaseDomain {

    /**
     * 农事材料编号
     */
    @TableId
    private String id;

    /**
     * 类型 (原材料购买, 原材料消耗, 能源消耗, 药品消耗)
     */
    private String type;

    /**
     * 价格
     */
    private String price;

    /**
     * 时间
     */
    private LocalDate time;

}
