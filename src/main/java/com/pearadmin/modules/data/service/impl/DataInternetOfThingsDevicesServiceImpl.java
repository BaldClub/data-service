package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataInternetOfThingsDevicesMapper;
import com.pearadmin.modules.data.domain.DataInternetOfThingsDevices;
import com.pearadmin.modules.data.service.IDataInternetOfThingsDevicesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 物联网设备数据Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataInternetOfThingsDevicesServiceImpl extends ServiceImpl<DataInternetOfThingsDevicesMapper,DataInternetOfThingsDevices> implements IDataInternetOfThingsDevicesService {


    /**
     * 查询物联网设备数据
     * @param dataInternetOfThingsDevices 物联网设备数据
     * @param pageDomain
     * @return 物联网设备数据 分页集合
     * */
    @Override
    public PageInfo<DataInternetOfThingsDevices> selectDataInternetOfThingsDevicesPage(DataInternetOfThingsDevices dataInternetOfThingsDevices, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataInternetOfThingsDevices> data = baseMapper.selectDataInternetOfThingsDevicesList(dataInternetOfThingsDevices);
        return new PageInfo<>(data);
    }

}
