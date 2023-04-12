package com.pearadmin.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 物联网设备数据Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataInternetOfThingsDevicesService extends IService<DataInternetOfThingsDevices> {

    /**
     * 查询物联网设备数据
     * @param dataInternetOfThingsDevices 物联网设备数据
     * @param pageDomain
     * @return 物联网设备数据 分页集合
     * */
    PageInfo<DataInternetOfThingsDevices> selectDataInternetOfThingsDevicesPage(DataInternetOfThingsDevices dataInternetOfThingsDevices, PageDomain pageDomain);

}
