package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 菌包环境实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_bag_environment")
public class DataBacterialBagEnvironment extends BaseDomain {

    /**
     * 菌包环境编号
     */
    @TableId
    private String id;

    /**
     * 空气温度 (摄氏度)
     */
    private String temperature;

    /**
     * 空气湿度 (%)
     */
    private String humidity;

    /**
     * PH值
     */
    private String ph;

    /**
     * 时间
     */
    private LocalDate time;
}
