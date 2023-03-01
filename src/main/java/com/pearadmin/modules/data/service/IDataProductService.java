package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataProduct;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 产品Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataProductService extends IService<DataProduct> {

    /**
     * 查询产品
     * @param dataProduct 产品
     * @param pageDomain
     * @return 产品 分页集合
     * */
    PageInfo<DataProduct> selectDataProductPage(DataProduct dataProduct, PageDomain pageDomain);

}
