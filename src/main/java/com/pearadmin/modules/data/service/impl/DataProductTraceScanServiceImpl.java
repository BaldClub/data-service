package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataProductTraceScanMapper;
import com.pearadmin.modules.data.domain.DataProductTraceScan;
import com.pearadmin.modules.data.service.IDataProductTraceScanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 产品溯源扫码数据Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataProductTraceScanServiceImpl extends ServiceImpl<DataProductTraceScanMapper,DataProductTraceScan> implements IDataProductTraceScanService {


    /**
     * 查询产品溯源扫码数据
     * @param dataProductTraceScan 产品溯源扫码数据
     * @param pageDomain
     * @return 产品溯源扫码数据 分页集合
     * */
    @Override
    public PageInfo<DataProductTraceScan> selectDataProductTraceScanPage(DataProductTraceScan dataProductTraceScan, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataProductTraceScan> data = baseMapper.selectDataProductTraceScanList(dataProductTraceScan);
        return new PageInfo<>(data);
    }

}
