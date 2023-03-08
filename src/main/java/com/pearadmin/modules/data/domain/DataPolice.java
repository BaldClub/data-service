package com.pearadmin.modules.data.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.pearadmin.common.web.base.BaseDomain;
import lombok.Data;

import java.time.LocalDate;

/**
 * 报警实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_police")
public class DataPolice extends BaseDomain {

    /**
     * 报警编号
     */
    @TableId
    private String id;

    /**
     * 报警类型 (环境报警, 生产报警, 设备报警, 农资农事报警, 监控报警)
     */
    private String type;

    /**
     * 时间
     */
    private LocalDate time;
    
}
