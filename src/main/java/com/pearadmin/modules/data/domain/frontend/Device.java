package com.pearadmin.modules.data.domain.frontend;

import lombok.Data;

@Data
public class Device {

    /**
     * 总数量
     */
    private String name;

    /**
     * 设备名 （类型）
     */
    private long count;

    /**
     * 在线率
     */
    private String online;

}
