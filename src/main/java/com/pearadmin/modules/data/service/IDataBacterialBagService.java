package com.pearadmin.modules.data.service;

import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataBacterialBag;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 菌包Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataBacterialBagService extends IService<DataBacterialBag> {

    /**
     * 查询菌包
     * @param dataBacterialBag 菌包
     * @param pageDomain
     * @return 菌包 分页集合
     * */
    PageInfo<DataBacterialBag> selectDataBacterialBagPage(DataBacterialBag dataBacterialBag, PageDomain pageDomain);

}
