package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 园区数据实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_park")
public class DataPark extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 工厂面积 */
    private Long factoryArea;

    /** 菇房数量 */
    private Long mushroomHouses;

    /** 栽培品种数量 */
    private Long cultivatedVarieties;

    /** 首页直播地址 */
    private String url;


}
