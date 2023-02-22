package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataParkMapper;
import com.pearadmin.modules.data.domain.DataPark;
import com.pearadmin.modules.data.service.IDataParkService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 园区数据Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataParkServiceImpl extends ServiceImpl<DataParkMapper,DataPark> implements IDataParkService {


    /**
     * 查询园区数据
     * @param dataPark 园区数据
     * @param pageDomain
     * @return 园区数据 分页集合
     * */
    @Override
    public PageInfo<DataPark> selectDataParkPage(DataPark dataPark, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataPark> data = baseMapper.selectDataParkList(dataPark);
        return new PageInfo<>(data);
    }

}
