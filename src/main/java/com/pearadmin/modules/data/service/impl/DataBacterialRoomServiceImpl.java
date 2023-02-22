package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataBacterialRoomMapper;
import com.pearadmin.modules.data.domain.DataBacterialRoom;
import com.pearadmin.modules.data.service.IDataBacterialRoomService;
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
public class DataBacterialRoomServiceImpl extends ServiceImpl<DataBacterialRoomMapper,DataBacterialRoom> implements IDataBacterialRoomService {


    /**
     * 查询菌房
     * @param dataBacterialRoom 菌房
     * @param pageDomain
     * @return 菌房 分页集合
     * */
    @Override
    public PageInfo<DataBacterialRoom> selectDataBacterialRoomPage(DataBacterialRoom dataBacterialRoom, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataBacterialRoom> data = baseMapper.selectDataBacterialRoomList(dataBacterialRoom);
        return new PageInfo<>(data);
    }

}
