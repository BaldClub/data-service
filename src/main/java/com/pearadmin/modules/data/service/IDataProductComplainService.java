package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataProductComplain;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 产品投诉Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataProductComplainService extends IService<DataProductComplain> {

    /**
     * 查询产品投诉
     * @param dataProductComplain 产品投诉
     * @param pageDomain
     * @return 产品投诉 分页集合
     * */
    PageInfo<DataProductComplain> selectDataProductComplainPage(DataProductComplain dataProductComplain, PageDomain pageDomain);

}
