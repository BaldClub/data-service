package com.pearadmin.modules.data.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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

}
