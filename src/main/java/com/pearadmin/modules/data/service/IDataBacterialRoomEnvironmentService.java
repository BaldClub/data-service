package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataBacterialRoomEnvironment;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菌房Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataBacterialRoomEnvironmentService extends IService<DataBacterialRoomEnvironment> {

    /**
     * 查询菌房
     * @param dataBacterialRoomEnvironment 菌房
     * @param pageDomain
     * @return 菌房 分页集合
     * */
    PageInfo<DataBacterialRoomEnvironment> selectDataBacterialRoomEnvironmentPage(DataBacterialRoomEnvironment dataBacterialRoomEnvironment, PageDomain pageDomain);

}
