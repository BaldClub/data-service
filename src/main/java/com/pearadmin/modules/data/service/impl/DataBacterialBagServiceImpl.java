package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataBacterialBagMapper;
import com.pearadmin.modules.data.domain.DataBacterialBag;
import com.pearadmin.modules.data.service.IDataBacterialBagService;
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
public class DataBacterialBagServiceImpl extends ServiceImpl<DataBacterialBagMapper,DataBacterialBag> implements IDataBacterialBagService {


    /**
     * 查询菌包
     * @param dataBacterialBag 菌包
     * @param pageDomain
     * @return 菌包 分页集合
     * */
    @Override
    public PageInfo<DataBacterialBag> selectDataBacterialBagPage(DataBacterialBag dataBacterialBag, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataBacterialBag> data = baseMapper.selectDataBacterialBagList(dataBacterialBag);
        return new PageInfo<>(data);
    }

}
