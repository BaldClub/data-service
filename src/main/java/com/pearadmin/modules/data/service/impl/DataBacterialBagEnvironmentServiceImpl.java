package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataBacterialBagEnvironmentMapper;
import com.pearadmin.modules.data.domain.DataBacterialBagEnvironment;
import com.pearadmin.modules.data.service.IDataBacterialBagEnvironmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 菌包Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataBacterialBagEnvironmentServiceImpl extends ServiceImpl<DataBacterialBagEnvironmentMapper,DataBacterialBagEnvironment> implements IDataBacterialBagEnvironmentService {


    /**
     * 查询菌包
     * @param dataBacterialBagEnvironment 菌包
     * @param pageDomain
     * @return 菌包 分页集合
     * */
    @Override
    public PageInfo<DataBacterialBagEnvironment> selectDataBacterialBagEnvironmentPage(DataBacterialBagEnvironment dataBacterialBagEnvironment, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataBacterialBagEnvironment> data = baseMapper.selectDataBacterialBagEnvironmentList(dataBacterialBagEnvironment);
        return new PageInfo<>(data);
    }

}
