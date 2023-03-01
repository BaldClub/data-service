package com.pearadmin.modules.data.domain;

import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.pearadmin.common.web.base.BaseDomain;

/**
 * 物联网设备数据实体
 *
 * @author leo
 * @date 2023-02-23
 */
@Data
@TableName("data_internet_of_things_devices")
public class DataInternetOfThingsDevices extends BaseDomain{

    /** $column.columnComment */
    @TableId
    private Long id;

    /** 设备状态 */
    private String status;

    /** 设备类型 (环境监测设备、远程监控设备、食用菌生产设备、溯源设备) */
    private String type;

    /** 设备价格 */
    private Long price;

    /** 配置时间 */
    private Date configTime;

    /** 直播视频链接 */
    private String url;


}
