package com.pearadmin.modules.data.service.impl;

import java.util.List;
import java.util.ArrayList;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pearadmin.common.web.domain.request.PageDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pearadmin.modules.data.mapper.DataCustomMapper;
import com.pearadmin.modules.data.domain.DataCustom;
import com.pearadmin.modules.data.service.IDataCustomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import java.util.Arrays;
/**
 * 自定义数据Service业务层处理
 *
 * @author leo
 * @date 2023-04-12
 */
@Service
public class DataCustomServiceImpl extends ServiceImpl<DataCustomMapper,DataCustom> implements IDataCustomService {


    /**
     * 查询自定义数据
     * @param dataCustom 自定义数据
     * @param pageDomain
     * @return 自定义数据 分页集合
     * */
    @Override
    public PageInfo<DataCustom> selectDataCustomPage(DataCustom dataCustom, PageDomain pageDomain) {
        PageHelper.startPage(pageDomain.getPage(), pageDomain.getLimit());
        List<DataCustom> data = baseMapper.selectDataCustomList(dataCustom);
        return new PageInfo<>(data);
    }

}
