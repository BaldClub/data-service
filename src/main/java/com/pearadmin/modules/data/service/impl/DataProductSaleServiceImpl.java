package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataProductSaleMapper;
import com.pearadmin.modules.data.domain.DataProductSale;
import com.pearadmin.modules.data.service.IDataProductSaleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 产品销售Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataProductSaleServiceImpl extends ServiceImpl<DataProductSaleMapper,DataProductSale> implements IDataProductSaleService {


    /**
     * 查询产品销售
     * @param dataProductSale 产品销售
     * @param pageDomain
     * @return 产品销售 分页集合
     * */
    @Override
    public PageInfo<DataProductSale> selectDataProductSalePage(DataProductSale dataProductSale, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataProductSale> data = baseMapper.selectDataProductSaleList(dataProductSale);
        return new PageInfo<>(data);
    }

}
