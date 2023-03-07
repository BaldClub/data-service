package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 菌房环境实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_bacterial_room_environment")
public class DataBacterialRoomEnvironment extends BaseDomain {

    /**
     * 菌房环境编号
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
     * 光照 (lux)
     */
    private String illumination;

    /**
     * 时间
     */
    private LocalDate time;

    /**
     * 二氧化碳浓度 (ppm)
     */
    private String carbonDioxide;

    /**
     * 一氧化碳浓度 (ppm)
     */
    private String carbonMonoxide;
}
