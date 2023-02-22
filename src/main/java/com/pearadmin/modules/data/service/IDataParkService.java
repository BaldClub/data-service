package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataPark;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 园区数据Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataParkService extends IService<DataPark> {

    /**
     * 查询园区数据
     * @param dataPark 园区数据
     * @param pageDomain
     * @return 园区数据 分页集合
     * */
    PageInfo<DataPark> selectDataParkPage(DataPark dataPark, PageDomain pageDomain);

}
