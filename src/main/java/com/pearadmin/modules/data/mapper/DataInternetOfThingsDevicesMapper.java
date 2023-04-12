package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

/**
 * 物联网设备数据Mapper接口
 *
 * @author leo
 * @date 2023-02-23
 */
@Mapper
public interface DataInternetOfThingsDevicesMapper extends BaseMapper<DataInternetOfThingsDevices> {

    /**
     * 查询物联网设备数据列表
     *
     * @param dataInternetOfThingsDevices 物联网设备数据
     * @return 物联网设备数据集合
     */
    List<DataInternetOfThingsDevices> selectDataInternetOfThingsDevicesList(DataInternetOfThingsDevices dataInternetOfThingsDevices);

    @Select("SELECT status, COUNT(*) as count FROM data_internet_of_things_devices WHERE type = '远程监控设备' AND status != '' GROUP BY status")
    List<Map<String, Object>> groupByStatus();
}
