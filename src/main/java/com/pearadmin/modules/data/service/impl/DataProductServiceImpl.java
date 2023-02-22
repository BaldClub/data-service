package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataProductMapper;
import com.pearadmin.modules.data.domain.DataProduct;
import com.pearadmin.modules.data.service.IDataProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 产品Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataProductServiceImpl extends ServiceImpl<DataProductMapper,DataProduct> implements IDataProductService {


    /**
     * 查询产品
     * @param dataProduct 产品
     * @param pageDomain
     * @return 产品 分页集合
     * */
    @Override
    public PageInfo<DataProduct> selectDataProductPage(DataProduct dataProduct, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataProduct> data = baseMapper.selectDataProductList(dataProduct);
        return new PageInfo<>(data);
    }

}
