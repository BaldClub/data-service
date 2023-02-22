package com.pearadmin.modules.data.service;

import java.util.List;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import com.pearadmin.modules.data.domain.DataProductSale;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 产品销售Service接口
 *
 * @author leo
 * @date 2023-02-23
 */
public interface IDataProductSaleService extends IService<DataProductSale> {

    /**
     * 查询产品销售
     * @param dataProductSale 产品销售
     * @param pageDomain
     * @return 产品销售 分页集合
     * */
    PageInfo<DataProductSale> selectDataProductSalePage(DataProductSale dataProductSale, PageDomain pageDomain);

}
