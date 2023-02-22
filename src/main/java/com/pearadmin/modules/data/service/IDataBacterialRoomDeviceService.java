package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataBacterialRoomDevice;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菌房设备Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataBacterialRoomDeviceService extends IService<DataBacterialRoomDevice> {

    /**
     * 查询菌房设备
     * @param dataBacterialRoomDevice 菌房设备
     * @param pageDomain
     * @return 菌房设备 分页集合
     * */
    PageInfo<DataBacterialRoomDevice> selectDataBacterialRoomDevicePage(DataBacterialRoomDevice dataBacterialRoomDevice, PageDomain pageDomain);

}
