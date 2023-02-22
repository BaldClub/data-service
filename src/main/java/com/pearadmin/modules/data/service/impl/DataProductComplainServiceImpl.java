package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataProductComplainMapper;
import com.pearadmin.modules.data.domain.DataProductComplain;
import com.pearadmin.modules.data.service.IDataProductComplainService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 产品投诉Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataProductComplainServiceImpl extends ServiceImpl<DataProductComplainMapper,DataProductComplain> implements IDataProductComplainService {


    /**
     * 查询产品投诉
     * @param dataProductComplain 产品投诉
     * @param pageDomain
     * @return 产品投诉 分页集合
     * */
    @Override
    public PageInfo<DataProductComplain> selectDataProductComplainPage(DataProductComplain dataProductComplain, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataProductComplain> data = baseMapper.selectDataProductComplainList(dataProductComplain);
        return new PageInfo<>(data);
    }

}
