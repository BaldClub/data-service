package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 农事统计实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_farming_statistics")
public class DataFarmingStatistics extends BaseDomain {

    /**
     * 编号
     */
    @TableId
    private String id;

    /**
     * 农事类型 (采摘, 病虫害防治, 菌包上下架)
     */
    private String type;

    /**
     * 次数
     */
    private Long count;

    /**
     * 时间
     */
    private LocalDate time;

}
