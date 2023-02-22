package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataBacterialRoomEnvironmentMapper;
import com.pearadmin.modules.data.domain.DataBacterialRoomEnvironment;
import com.pearadmin.modules.data.service.IDataBacterialRoomEnvironmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 菌房Service业务层处理
 *
 * @author leo
 * @date 2023-02-23
 */
@Service
public class DataBacterialRoomEnvironmentServiceImpl extends ServiceImpl<DataBacterialRoomEnvironmentMapper,DataBacterialRoomEnvironment> implements IDataBacterialRoomEnvironmentService {


    /**
     * 查询菌房
     * @param dataBacterialRoomEnvironment 菌房
     * @param pageDomain
     * @return 菌房 分页集合
     * */
    @Override
    public PageInfo<DataBacterialRoomEnvironment> selectDataBacterialRoomEnvironmentPage(DataBacterialRoomEnvironment dataBacterialRoomEnvironment, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataBacterialRoomEnvironment> data = baseMapper.selectDataBacterialRoomEnvironmentList(dataBacterialRoomEnvironment);
        return new PageInfo<>(data);
    }

}
